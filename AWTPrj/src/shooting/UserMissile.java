package shooting;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class UserMissile {
	
	private int x;
	private int y;
	private GameBoard parent;
	private static Image img;
	
	static
	{
		img = Toolkit.getDefaultToolkit().getImage("res/missile.png");
	}
	
	public UserMissile()
	{
		this(0,0,null);
	}
	
	public UserMissile(int x, int y, GameBoard parent)
	{
		this.x=x;
		this.x=y;
		this.parent=parent;
	}

	
	public void move() 
	{
		y-=5;
	}

	public void paint(Graphics g)
	{
		g.drawImage(img, x, y, parent);
	}


	public int getX() 
	{
		return x;
	}


	public void setX(int x) 
	{
		this.x = x;
	}


	public int getY() 
	{
		return y;
	}


	public void setY(int y) 
	{
		this.y = y;
	}

	
	public boolean hasCrashed(EnemyFighter ef)
	{
		int w = 70;
		int h = 70;
		
		if((x > ef.getX() && x < ef.getX() +w) 
				&& (y > ef.getY() && y < ef.getY() +h))
			return true;
		return false;
			
	}

	
	
}
