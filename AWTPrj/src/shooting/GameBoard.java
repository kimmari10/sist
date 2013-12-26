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
	
	//게임상태변수들
	
	private int key;
	private int spaceKey;
	
	
	private Random rand = new Random();
	private int timerToEnemyAppear; 
	private int timerToFire; 

	
	public GameBoard() // 게임보드 이미지와 객체생성
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		bg = tk.getImage("res/22.jpg");
		
		userfighter = new UserFighter();
		status = new StatusBar();
		
		score=0;
		
		

		
		
		
		
		//익명 클래스
		addKeyListener(new KeyAdapter(){  //키아답터는 키이벤트 빈함수를 이미 포함하고있음 
			
			public void keyPressed(KeyEvent e) 
			{
				int key=e.getKeyCode(); //코드값 정수형으로 반환 저장
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
	
	
	public void start()  // 쓰레드 서비스 함수들 - 메인프레임에서 실행하기위함.
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
		
		for(int i=0; i<enemies.size(); i++)  // 적기 이동
			((EnemyFighter)enemies.get(i)).move();
		
		if(timerToEnemyAppear-- == 0) //적기출현 빈도수 설정
		{
			enemies.add(new EnemyFighter(this));
			timerToEnemyAppear = (rand.nextInt(500)+0)/17;
		} 
		
		//내미사일 발싸
		

		if(timerToFire>0)
			timerToFire--;
		
		if(spaceKey == KeyEvent.VK_SPACE)  // 스페이스키 눌렀을때 미사일을 일정간격으로 발싸@@
		{
			if(timerToFire == 0)
			{
				UserMissile um = userfighter.fire();
				missiles.add(um);
				timerToFire =7;
			}
			
		}
		
		for(int i=0; i<missiles.size(); i++)  // 각 미사일 무브
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
			
		
		
		
		
		//적미사일 발싸 (각각?)
		
/*		EnemyMissile em = enemyfighter.fire();

		if(timerToFire-- == 0)
		{
			missiles2.add(em);
			timerToFire =40;
		}
			
		
		for(int i=0; i<missiles2.size(); i++)  // 각 미사일 무브
			((EnemyMissile)missiles2.get(i)).move();
		
		*/
		
		
		
		

	public void update(Graphics g) {
		
		//super.update(g);
		paint(g);
		
	}
	

	public void paint(Graphics g) //오버라이드함
	{
		//super.paint(g);
		
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics g1 = buf.getGraphics();
		
		//------------------------------------------------------
		g1.drawImage(bg, 0, 0, this); //배경그리기 , 더블버퍼링
		userfighter.paint(g1, this); //나 그리기
		

		
		for(int i=0; i<enemies.size(); i++) // 적기 그리기
			((EnemyFighter)enemies.get(i)).paint(g1);
		
		for(int i=0; i<missiles.size(); i++) //내미사일 그리기
			((UserMissile)missiles.get(i)).paint(g1);
		
			
		
/*		for(int i=0; i<missiles2.size(); i++) //적미사일 그리기
			((EnemyMissile)missiles2.get(i)).paint(g1);
*/
		
		g.drawImage(buf, 0, 0, this);
	}

	
	
}
