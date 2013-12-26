package collection;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class EnemyFighter extends Canvas {
	
	private EnemyMissile[] enemymissiles;
	private static final int right = 2;
	private static final int left = 1;
	
	private int x;
	private int y;
	private int dir;   
	private int speed;
	
	private int delay;
	
	private int timer;
	
	private int offsetX;
	private int offsetY;
	
	private int leftWall;
	private int rightWall;
	
	private boolean isBursting;
	private boolean doneBurst;
	
	private static Image img;
	private static Image imgBurst;
	
	private GameBoard parent;
	private Random rand = new Random();
	
	static
	{
		img = Toolkit.getDefaultToolkit().getImage("res/user.jpg");
		imgBurst = Toolkit.getDefaultToolkit().getImage("res/explosion.png");
	}
	
	
	public EnemyFighter(GameBoard parent)
	{
		x = rand.nextInt(400);
		y = -100;
		speed=rand.nextInt(3)+1;
		
		enemymissiles = new EnemyMissile[100];
		this.parent = parent;
		
		dir = rand.nextInt(2)+1;
		
		leftWall = rand.nextInt(400);
		rightWall = rand.nextInt(400-x)+x;
		
		isBursting = false;
		doneBurst = false;
		
		
		offsetX=0;
		offsetY=0;
		
		delay=5;
		
		move();
		
	}
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move() 
	{
		
		if(x<leftWall)
		{
			dir=right;
			rightWall = rand.nextInt(400-x)+x;
		}
		
		
		if(x>rightWall)
		{
			dir=left;
			leftWall=rand.nextInt(x);
		}
		
		
		
		if(dir==left)
		{
			x-=speed;
			y+=speed;
		}
		else if(dir==right)
		{
			x+=speed;
			y+=speed;
		}
	}
	
	
	
	public void paint(Graphics g) 
	{
		g.drawImage(img, x, y, parent);
		
		if(isBursting)
			g.drawImage(imgBurst, x-100, y-50, x+160, y+120 , offsetX, offsetY, offsetX+160, offsetY+120, parent);
	}
					
				
					
				

	
	public EnemyMissile fire() 
	{
		EnemyMissile em = new EnemyMissile(); 
		em.setX(this.x+25);
		em.setY(this.y+112);
		
		return em;
	}

	
	public boolean hasBurst() 
	{
		if(--delay >0)
			return false;
					
			delay = 1;
			
			
		if(isBursting)
		{
			if(offsetX==640-160)
			{
				offsetX=0;
				offsetY+=120;
			}
			offsetX+=160;
		}
		
		if(offsetY==600-120)
			return true;
		
		return false;
		
		
	}

	public void burst() 
	{
		isBursting=true;
	}


}
