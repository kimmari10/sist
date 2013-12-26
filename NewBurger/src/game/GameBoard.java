package game;

import game.manager.BurgerManager;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameBoard extends Canvas implements Runnable{

	private Burger burger;
	private BurgerManager mBurgerManager;
	
	private ArrayList patties;
	private ArrayList lettuces;
	private ArrayList cheeses;
	private ArrayList bread;
	
	private int delay;
	private int delay2;
	private Thread thread;
	private Image win;
	private Image lose;

	//�����������
	public static int score;
	private int time; // ���ӽð�
	private int timer;//����������
	private int timer2; //�ð�����
	private int timeX;
	private Clip clip;

	//������Ű���
	private Random rand = new Random();
	private int order[]; 
	private int ran;
	private int mat;
	private int layer[];
	private boolean exist;
	
	private int cnt;
	private int compare[];
	private boolean cntCompare;
	
	//�̹�����
	private Image bg;
	private Image gg;
	private Image burgerImage;
	private Image pattyImg;
	private Image cheeseImg;
	private Image lettuceImg;
	private Image upbread;
	private Image downbread;

	private Image people1;
	private Image people2;
	private Image people3;
	private Image people4;
	private Image people5;
	private Image people6;
	
	private Image student1;
	private Image student2;
	private Image student3;
	private Image student4;
	
	
	//Ű�������� �ʵ�
	private int keyQ;
	private int keyW;
	private int keyE;
	private int keySpace;
	private boolean isPressed = false;
	
	
	//�׸��� ���� �ʵ�
	private Graphics g1;
	private Image buf;
	
	private int count;
	private int countCompare;
	private int peopleDelay;
	private boolean isBread = false;
	private boolean direction;
	private int movingArea;
	private int studentDelay;
	
	
	public GameBoard()
	{
		direction = true;
		movingArea = 100;
		peopleDelay = 80;
		studentDelay = 600;
		delay2 =0;
		delay = 0;
		
		
		delay2 =0;
		delay = 0;
		timeX=100;
		compare = new int[100];
		count = 0;
		countCompare = 0;

		cnt = -1;
		timer =0;
		
		exist= false;
		
		layer = new int[7];    //�������� ���� y��ǥ �̸�����
		for(int i=0; i<7; i++)
			layer[i] = 170-i*15; 
		
		time = 60;
		score = 0;
		
		student1 = Toolkit.getDefaultToolkit().getImage("res/walkingClient55.png");
		student2 = Toolkit.getDefaultToolkit().getImage("res/walkingClient66.png");
		student3 = Toolkit.getDefaultToolkit().getImage("res/walkingClient77.png");
		student4 = Toolkit.getDefaultToolkit().getImage("res/walkingClient88.png");
		
		people1 = Toolkit.getDefaultToolkit().getImage("res/movingClient1.png");
		people2 = Toolkit.getDefaultToolkit().getImage("res/movingClient2.png");
		people3 = Toolkit.getDefaultToolkit().getImage("res/movingClient3.png");
		people4 = Toolkit.getDefaultToolkit().getImage("res/movingClient4.png");
		people5 = Toolkit.getDefaultToolkit().getImage("res/movingClient5.png");
		people6 = Toolkit.getDefaultToolkit().getImage("res/movingClient6.png");
		lose = Toolkit.getDefaultToolkit().getImage("res/lose.png");
		win = Toolkit.getDefaultToolkit().getImage("res/win.png");
		gg = Toolkit.getDefaultToolkit().getImage("res/gg.png");
		bg = Toolkit.getDefaultToolkit().getImage("res/bg.png");
		burgerImage = Toolkit.getDefaultToolkit().getImage("res/cheese.png");
		pattyImg = Toolkit.getDefaultToolkit().getImage("res/patty.png");
		cheeseImg = Toolkit.getDefaultToolkit().getImage("res/cheese.png");
		lettuceImg = Toolkit.getDefaultToolkit().getImage("res/lettuce.png");
		upbread = Toolkit.getDefaultToolkit().getImage("res/upbread.png");
		downbread = Toolkit.getDefaultToolkit().getImage("res/downbread.png");
		
		burger = new Burger();
		mBurgerManager = new BurgerManager();
		
		addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
			}

			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				// Ȥ�� �� ���� ���� ������ isPressed (Boolean �߰���)
				if (!isPressed) {
					if (key == KeyEvent.VK_Q) 
					{
						++cnt;
						keyQ = key;
						compare[cnt] = 1;
					} 
					
					else if (key == KeyEvent.VK_W) 
					{
						++cnt;
						keyW = key;
						compare[cnt] = 2;

					} 
					
					else if (key == KeyEvent.VK_E) 
					{
						++cnt;
						keyE = key;
						compare[cnt] = 3;
					} 
					
					else if (key == KeyEvent.VK_SPACE) 
					{
						keySpace = key;
					} 
					
					else if (key == KeyEvent.VK_ENTER) // ENTER Ű
					{
						mBurgerManager.reMove();
						count=0;
						cnt=-1;
					}
//					else if (key == KeyEvent.VK_ENTER)  // ����Ű ���� 
//					{
//						if(mBurgerManager.size() >= 1) 
//						{
//						
//							for(int i=0; i < order.length; i++)
//							{
//								if((order[i] == compare[i]))
//									count++;
//								
//								if( count == order.length)
//									countCompare = 1;
//								else
//									countCompare = 2;
//							}
//						}
//					}
					isPressed = true;
					addItems();
				}
				

			}
			
			public void keyReleased(KeyEvent e){
				super.keyReleased(e);
				
				int key=e.getKeyCode(); 
				switch(key)
				{
					case KeyEvent.VK_Q:
						if(keyQ== KeyEvent.VK_Q)	
							keyQ = 0;
							break;
						
					case KeyEvent.VK_W:
						if(keyW== KeyEvent.VK_W)	
							keyW = 0;
							break;
					
					case KeyEvent.VK_E:
						if(keyE== KeyEvent.VK_E)	
							keyE = 0;
							break;
						
					case KeyEvent.VK_SPACE:
						if(keySpace== KeyEvent.VK_SPACE)	
							keySpace = 0;
							break;
				}
				isPressed = false;
			}
			
		});
		
		patties = new ArrayList();
		lettuces = new ArrayList();
		cheeses = new ArrayList();
		bread = new ArrayList();
		
		
	}
		
	public void start()  // ������ ���� �Լ��� - ���������ӿ��� �����ϱ�����. // �̻��
	{
		if(thread == null)
		{
			thread = new Thread(this);
			thread.start();
			Sound("res/music/grandfa.wav", true);	 // ���� �������
			
			
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
			/**�̹����� ���������� �׷����ϱ⿡ �����忡�� �ش� ������ ���길 �����*/
			updateItems();
			repaint();
			try{
				Thread.sleep(17);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	/**������ �߰��� Ű�̺�Ʈ ���� ��� �߰��Ѵ�.*/
	/**������ ������ ȿ�� ���� �߻�, - �������� �� ȿ������� **/
	private void addItems(){
			
		
		if(keyQ == KeyEvent.VK_Q) // qŰ�� ��Ƽ����
		{
				Patty pt = burger.fire1();
				mBurgerManager.add(pt);
				score+=3;
				Sound("res/music/fall.wav", false); //ȿ�������
		}	
			
		
		if(keyW == KeyEvent.VK_W) // wŰ�� ġ�����
		{
				Cheese cs = burger.fire3();
				mBurgerManager.add(cs);
				score+=3;
				Sound("res/music/fall.wav", false); //ȿ�������
		}
		

		if(keyE == KeyEvent.VK_E) // eŰ�� ����߻���
		{
				Lettuce lt = burger.fire2();
				mBurgerManager.add(lt);
				score+=3;
				Sound("res/music/fall.wav", false); //ȿ�������
		}

		if(keySpace == KeyEvent.VK_SPACE) // ���Ѳ� ����
		{
			if(mBurgerManager.size() >= ran)
			{
					Bread bd = burger.fire4();
					mBurgerManager.add(bd);
					Sound("res/music/fall.wav", false); //ȿ�������
					autoCompare();
			}
		}
	}
		
			
	
	private void updateItems()
	{
		mBurgerManager.move(); // ����̵�

	}
	
			
	public void update(Graphics g)
	{
		
		paints();
		paintOrder(); 
		isDead(); //�״��� �Ǵ�
		autoCompare();

		g.drawImage(buf, 0,0, this);
	}
	

	public void autoCompare()// ���� ������ ũ��� �������� ũ������ؼ� �ڵ� ���ϰԸ���
	{
		
		if(mBurgerManager.size() >= ran+1) 
		{
			if(mBurgerManager.getY() >= (480 - ((mBurgerManager.size()+1) * 15)))
			{
				for(int i=0; i < order.length; i++)
				{
					if((order[i] == compare[i]))
						count++;
					
					if( count == order.length)
						countCompare = 1;
						
					else
						countCompare = 2;
				}
			}
			compare();
		}
	}
	
	public void compare() // �ܹ��� �� ��� ���� �Լ�
	{
		if (countCompare == 1) 
		{

			delay = 30;
			mBurgerManager.reMove();
			exist = false;
			countCompare=0;
			score+=100; //��������
			timeX += 10; // �ð������� ����
			cnt = -1;
			count = 0;
			Sound("res/music/success3.wav", false); //�������� ��� ȿ�������
		}
		
		else if(countCompare == 2)
		{
			delay2 = 30;
			mBurgerManager.reMove();
			exist = false;
			countCompare=0;
			score-=50; //��������
			timeX-=10;  //�ð������� ����
			cnt = -1;
			count = 0;
			countCompare=0;
			Sound("res/music/fail3.wav", false); //�������� ��� ȿ�������
		}
	}
	
	public void paintOrder() //�����׸���
	{
		
		if(exist==false)
		{
			ran = rand.nextInt(3)+3; // ������Ż����� ��������  3~5�� ���� 
			
			order = new int[ran]; // ���Ż����� ��ü����

			for(int i=0; i<ran; i++) // ���Ż����ŭ for��
			{
				for(int j=0; j<3; j++)
				order[i] = rand.nextInt(3)+1;
			}
			exist=true;
		}
		
		g1.drawImage(downbread, 770, layer[0]+15, this); //�Ʒ��Ѳ�
		
			for(int i=0; i<ran; i++) //order���� ��Ḧ �׷���
			{
				switch(order[i])
				{
					case 1:
						g1.drawImage(pattyImg, 770, layer[i], this);
						break;
					case 2:
						g1.drawImage(cheeseImg, 770, layer[i], this);
						break;
					case 3:
						g1.drawImage(lettuceImg, 770, layer[i], this);
						break;
				}
			}
			g1.drawImage(upbread, 770, layer[ran+1],this); //���Ѳ�
			

	}
	
	public void paints()
	{
		g1.drawImage(bg, 0, 0, this); //���
		mBurgerManager.paint(g1); // ��� �׸���
		gameTime(); // ���ӽð�
		client();
		g1.drawString(Integer.toString(score), 940, 33); // ���ھ� �׸���
		
//		if(delay-- >= 0)
//		{
//			g1.drawImage(win, 710, 280, this);
//		}
//		if(delay2-- >= 0)
//		{
//			g1.drawImage(lose, 720, 280, this);
//		}
		
	}
	
	public void gameTime()
	{
		
		if(timer2==56)
		{
			time--;
			timer2=0;
		}
		if(timer==10)
		{
			timer=0;
			timeX-=3;  // ������ X��ǥ
			
		}
		g1.setFont(new Font("�⺻", Font.BOLD,  20));// �ѹ��� ó���ϸ� �� �ذ�ɰŰ�����...........
		timer++;
		timer2++;
		
		
		g1.drawImage(gg, 44, 8, timeX+44, 8+33,    0,0,   800, 33,   this);
		
		
		
		
	}
	
	public void paint(Graphics g)
	{
		buf = createImage(this.getWidth(), this.getHeight());
		g1 = buf.getGraphics(); // �������

		update(g);
	} 
	
	public void setScore(int s)
	{
		
		score = s;
	}
	
	public void setTimeX(int s)
	{
		timeX = s;
	}
	
	public void isDead()  // ������ ���ӿ��� ����
	{
		if(timeX <= 0) //�ð��������� 0�� �ȴٸ�
		{
			MainFrame.getIns().change(BoardType.gameOver);
			mBurgerManager.reMove();
		}
	}
	
	public void client()
	{
		// /////////////////////////////////////////�ĸ��Ӹ�
		if (peopleDelay >= 60 && peopleDelay <= 80) {
			g1.drawImage(people4, 200, 360, this);
			peopleDelay--;
		} else if (peopleDelay >= 40 && peopleDelay <= 59) {
			g1.drawImage(people5, 200, 360, this);
			peopleDelay--;
		} else if (peopleDelay >= 20 && peopleDelay <= 39) {
			g1.drawImage(people6, 200, 360, this);
			peopleDelay--;
		} else if (peopleDelay >= 0 && peopleDelay <= 19) {
			g1.drawImage(people5, 200, 360, this);
			peopleDelay--;
		} else
			peopleDelay = 80;

		// /////////////////////////////////////////////�ɲ�����
		if (peopleDelay >= 60 && peopleDelay <= 80) {
			g1.drawImage(people1, 140, 420, this);
			peopleDelay--;
		} else if (peopleDelay >= 40 && peopleDelay <= 59) {
			g1.drawImage(people2, 140, 420, this);
			peopleDelay--;
		} else if (peopleDelay >= 20 && peopleDelay <= 39) {
			g1.drawImage(people3, 140, 420, this);
			peopleDelay--;
		} else if (peopleDelay >= 0 && peopleDelay <= 19) {
			g1.drawImage(people2, 140, 420, this);
			peopleDelay--;
		} else
			peopleDelay = 80;

		// /////////////////////////////////////////////////////////���

		if (direction == true) {
			if (studentDelay >= 300 && studentDelay <= 600) {
				g1.drawImage(student1, movingArea, 200, this);
				studentDelay -= 10;
				movingArea += 2;
			} else if (studentDelay >= 0 && studentDelay <= 299) {
				g1.drawImage(student2, movingArea, 200, this);
				studentDelay -= 10;
				movingArea += 2;
			} else {
				if (movingArea >= 160) {
					direction = false;
				}
				studentDelay = 600;
			}

			if (studentDelay >= 300 && studentDelay <= 600) {
				g1.drawImage(null, movingArea, 200, this);
				studentDelay -= 10;
				movingArea += 2;
			} else if (studentDelay >= 0 && studentDelay <= 299) {
				g1.drawImage(null, movingArea, 200, this);
				studentDelay -= 10;
				movingArea += 2;
			} else {
				if (movingArea >= 160) {
					direction = false;
				}
				studentDelay = 600;
			}
		}

		if (direction == false) {
			if (studentDelay >= 300 && studentDelay <= 600) {
				g1.drawImage(student3, movingArea, 150, this);
				studentDelay -= 10;
				movingArea -= 2;
			} else if (studentDelay >= 0 && studentDelay <= 299) {
				g1.drawImage(student4, movingArea, 150, this);
				studentDelay -= 10;
				movingArea -= 2;
			} else {
				if (movingArea <= -160) {
					direction = true;
				}
				studentDelay = 600;
			}

			if (studentDelay >= 300 && studentDelay <= 600) {

				g1.drawImage(null, movingArea, 150, this);
				studentDelay -= 10;
				movingArea -= 2;
				g1.drawImage(null, movingArea, 150, this);
			} else if (studentDelay >= 0 && studentDelay <= 299) {
				g1.drawImage(null, movingArea, 150, this);
				studentDelay -= 10;
				movingArea -= 2;
				g1.drawImage(null, movingArea, 150, this);
			} else {
				if (movingArea <= -160) {
					direction = true;
				}
				studentDelay = 600;
			}
		}

		g1.drawImage(null, movingArea, 150, this);
		g1.drawImage(null, movingArea, 150, this);
		g1.drawImage(null, movingArea, 150, this);
		g1.drawImage(null, movingArea, 150, this);

		if (delay-- >= 0) {
			g1.drawImage(win, 710, 280, this);
		}
		if (delay2-- >= 0) {
			g1.drawImage(lose, 720, 280, this);
		}
	}
	
	private void Sound(String file, boolean Loop) { //�Ҹ���� �Լ�
		try {
			AudioInputStream ais = AudioSystem
					.getAudioInputStream(new BufferedInputStream(
							new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if (Loop)
				clip.loop(-1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
