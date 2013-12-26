package shooting;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends Canvas implements Runnable{
	
	private UserFighter userfighter;
	private EnemyFighter enemyfighter;
	private ArrayList enemies;
	private ArrayList missiles;
	private ArrayList clients;
	
	private StatusBar status;
	private Image bg;
	
	private int score;
	
	private Thread thread;
	
	//���ӻ��º�����
	
	private int key;
	private int spaceKey;
	
	
	private Random rand = new Random();
	private int timerToEnemyAppear; 
	private int timerToFire; 

	
	public GameBoard() // ���Ӻ��� �̹����� ��ü����
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		bg = tk.getImage("res/22.jpg");
		
		userfighter = new UserFighter();
		status = new StatusBar();
		
		score=0;
		
		

		
		
		
		
		//�͸� Ŭ����
		addKeyListener(new KeyAdapter(){  //Ű�ƴ��ʹ� Ű�̺�Ʈ ���Լ��� �̹� �����ϰ����� 
			
			public void keyPressed(KeyEvent e) 
			{
				int key=e.getKeyCode(); //�ڵ尪 ���������� ��ȯ ����
				switch(key)
				{
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_RIGHT:
					case KeyEvent.VK_UP:
					case KeyEvent.VK_DOWN:
						GameBoard.this.key = key;
						break;
				}
				
				if(key == KeyEvent.VK_SPACE)
					spaceKey = key;
				//repaint(); 
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);

				int key=e.getKeyCode(); 
				switch(key)
				{
					case KeyEvent.VK_LEFT:
						if(GameBoard.this.key== KeyEvent.VK_LEFT)	
							GameBoard.this.key = 0;
							break;
					case KeyEvent.VK_RIGHT:
						if(GameBoard.this.key== KeyEvent.VK_RIGHT)	
							GameBoard.this.key = 0;
							break;
					case KeyEvent.VK_UP:
						if(GameBoard.this.key== KeyEvent.VK_UP)	
							GameBoard.this.key = 0;
							break;
					case KeyEvent.VK_DOWN:
						if(GameBoard.this.key== KeyEvent.VK_DOWN)	
							GameBoard.this.key = 0;
							break;
					case KeyEvent.VK_SPACE:
						if(spaceKey== KeyEvent.VK_SPACE)	
							spaceKey = 0;
						break;
				}
				
			}

		});
		//start();
		enemies = new ArrayList();
		missiles = new ArrayList();
		
		
		
		
		
		
			
	}
	
	
	public void start()  // ������ ���� �Լ��� - ���������ӿ��� �����ϱ�����.
	{
		if(thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
		else
			thread.resume();
	}
	
	public void pause()
	{
		thread.suspend();
	}
	
	public void stop()
	{
		thread.stop();
	}
	
	
	
	public void run()
	{
		while(true)
		{
			updateItems();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
	private void updateItems() 
	
	{
		if(key != 0 )
			userfighter.move(key);
		
		for(int i=0; i<enemies.size(); i++)  // ���� �̵�
			((EnemyFighter)enemies.get(i)).move();
		
		if(timerToEnemyAppear-- == 0) //�������� �󵵼� ����
		{
			enemies.add(new EnemyFighter(this));
			timerToEnemyAppear = (rand.nextInt(500)+0)/17;
		} 
		
		//���̻��� �߽�
		

		if(timerToFire>0)
			timerToFire--;
		
		if(spaceKey == KeyEvent.VK_SPACE)  // �����̽�Ű �������� �̻����� ������������ �߽�@@
		{
			if(timerToFire == 0)
			{
				UserMissile um = userfighter.fire();
				missiles.add(um);
				timerToFire =7;
			}
			
		}
		
		for(int i=0; i<missiles.size(); i++)  // �� �̻��� ����
			((UserMissile)missiles.get(i)).move();
		
		
		
		
		for(int ei=0; ei<enemies.size(); ei++)
		{
			EnemyFighter ef= (EnemyFighter)enemies.get(ei);
		
			for(int i=0; i<missiles.size(); i++)
			{
				UserMissile um = (UserMissile)missiles.get(i); 
				if(um.hasCrashed(ef))
				{
					ef.burst();
					missiles.remove(um);
				}
			}
		}
			
			
			
			for(int ei=0; ei<enemies.size(); ei++)
			{
				EnemyFighter ef= (EnemyFighter)enemies.get(ei);
					if(ef.hasBurst())
					{
						enemies.remove(ef);
						score+=100;
						System.out.println(score);
					}
					
			}		
			
	}
			
		
		
		
		
		//���̻��� �߽� (����?)
		
/*		EnemyMissile em = enemyfighter.fire();

		if(timerToFire-- == 0)
		{
			missiles2.add(em);
			timerToFire =40;
		}
			
		
		for(int i=0; i<missiles2.size(); i++)  // �� �̻��� ����
			((EnemyMissile)missiles2.get(i)).move();
		
		*/
		
		
		
		

	public void update(Graphics g) {
		
		//super.update(g);
		paint(g);
		
	}
	

	public void paint(Graphics g) //�������̵���
	{
		//super.paint(g);
		
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics g1 = buf.getGraphics();
		
		//------------------------------------------------------
		g1.drawImage(bg, 0, 0, this); //���׸��� , ������۸�
		userfighter.paint(g1, this); //�� �׸���
		

		
		for(int i=0; i<enemies.size(); i++) // ���� �׸���
			((EnemyFighter)enemies.get(i)).paint(g1);
		
		for(int i=0; i<missiles.size(); i++) //���̻��� �׸���
			((UserMissile)missiles.get(i)).paint(g1);
		
			
		
/*		for(int i=0; i<missiles2.size(); i++) //���̻��� �׸���
			((EnemyMissile)missiles2.get(i)).paint(g1);
*/
		
		g.drawImage(buf, 0, 0, this);
	}

	
	
}
