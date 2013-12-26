package role;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GameBoard extends Canvas implements Runnable {

	private ArrayList mans;
	private ArrayList stores;
	private Thread thread;
	private boolean isRunning;
	private int hKey;
	private int vKey;
	private Man man;
	
	private JTextArea txtInput;
	private JButton btnSent;
	
	private Scanner scan;
	private PrintWriter nout;

	
	private Image img;
	
	private ChatBox chatBox;
	private MsgBox msgBox;
	
	public GameBoard()
	{
		msgBox = new MsgBox();
		img = Toolkit.getDefaultToolkit().getImage("res/bgimg.png");
		thread = null; 
		mans = new ArrayList();
		stores = new ArrayList();
		
		Man man = new Man(300, 200, Man.hostType, this);
		mans.add(man);


		
		//txtInput = new JTextArea();
		//btnSent = new JButton(); // 페인트 만들필요 없음

		
		
		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) 
			{
				int key = e.getKeyCode();  
				switch(key)
				{
				case KeyEvent.VK_LEFT :
				case KeyEvent.VK_RIGHT :
					GameBoard.this.hKey=key;
					break;
				case KeyEvent.VK_UP :
				case KeyEvent.VK_DOWN :
					GameBoard.this.vKey=key;
					break;
				}
			}
			
			public void keyReleased(KeyEvent e) 
			{
				int key = e.getKeyCode();  
				switch(key)
				{
				case KeyEvent.VK_LEFT :
					if(GameBoard.this.hKey==KeyEvent.VK_LEFT)
						GameBoard.this.hKey=0;
					break;
				case KeyEvent.VK_RIGHT :
					if(GameBoard.this.hKey==KeyEvent.VK_RIGHT)
						GameBoard.this.hKey=0;
					break;
				case KeyEvent.VK_UP :
					if(GameBoard.this.vKey==KeyEvent.VK_UP)
						GameBoard.this.vKey=0;
					break;
				case KeyEvent.VK_DOWN :
					if(GameBoard.this.vKey==KeyEvent.VK_DOWN)
						GameBoard.this.vKey=0;
					break;
				}
			
			}
		});
		
	}
	
	public void run() 
	{
		while(isRunning)
		{
			if(vKey!=0  || hKey!=0)  // 키값 입력받으면 walk실행
				for(int i = 0; i<mans.size(); i++)
				{					
					Man man = (Man)mans.get(i);
					if(man.getType()==Man.hostType)
						((Man)mans.get(i)).walk(hKey,vKey); 
				}
			
			else
				
				for(int i = 0; i<mans.size(); i++)
				{
					Man man = (Man)mans.get(i);
					if(man.getType()==Man.hostType)
						((Man)mans.get(i)).stop();
				}
			
			for(int i =0; i<mans.size(); i++)
			{
				Man man = (Man)mans.get(i);
				if(man.getType()==Man.hostType)
				{
					msgBox.setX(man.getX()+40);
					msgBox.setY(man.getY()-10);
				}
			}
			

			
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	Graphics g1;
	
	
	public void paint(Graphics g) 
	{
		Image buf = this.createImage(this.getWidth(), this.getHeight());
		g1 = buf.getGraphics();
		
		g1.drawImage(img, 0, 0, this);
		
		for(int i = 0; i<mans.size(); i++)
			((Man)mans.get(i)).paint(g1);
		
		msgBox.paint(g1);
		
		
		g.drawImage(buf, 0, 0, this);
		
		
	}
	
	public void update(Graphics g) // 리페인트를 호출할경우 호출됨 
	{
		//super.update(g);
		paint(g);
	}

	public void start(){
		if(thread==null)
		{
			isRunning = true;
			thread = new Thread(this); // 러너블을 구현하고 있는 객체를 넘겨줌
			thread.start();
		}
		else
			thread.resume();
	}
	
	public void pause()
	{
		thread.suspend();
		isRunning=false;
	}
	
	public void stop()
	{
		thread.stop();
		isRunning = false;
	}

	public void showMessage(String msg) 
	{
		int w = g1.getFontMetrics().stringWidth(msg); //msg의 길이를 구함
				
		msgBox.setWidth(w); //
		msgBox.setMsg(msg);
	}

	public void hasJoined() //주체는 서버, 클라이언트가 접속했을때 기능
	{
		Man friend = new Man(300, 200, Man.friendType, this);
		mans.add(man);
		
		for(int i =0; i<mans.size(); i++)
		{
			man = (Man)mans.get(i);
			if(man.getType() == Man.hostType)
				break;
		}
		
		nout.println(String.format("%d %d", man.getX(), man.getY()));  //인코딩, 마샬링, 시리얼라이제이션-줄세운다
		
	}

	public void setOut(PrintWriter nout) 
	{
		this.nout = nout;
	}

	public void setScan(Scanner scan) 
	{
		this.scan = scan;
	}

	public void addMan(Man friend) //접속되면 프렌드를 추가해줌
	{
		mans.add(friend);
	}


	
	
	
}
