package collection;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class EnemyMissile {
	
	private int x;
	private int y;
	private GameBoard parent;
	private static Image img;
	
	static
	{
		img = Toolkit.getDefaultToolkit().getImage("res/fireball.png");
	}
	
	public EnemyMissile()
	{
		this(0,0,null);
	}
	
	public EnemyMissile(int x, int y, GameBoard parent)
	{
		this.x=x;
		this.x=y;
		this.parent=parent;
	}

	
	public void move() 
	{
		y+=3;
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

	
	
	
	
}
