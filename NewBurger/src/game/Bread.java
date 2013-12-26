package game;

import game.protocol.IDrawable;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Bread implements IDrawable{
	
	private int x;
	private int y;
	private GameBoard parent;
	private static Image img;
	
	static
	{
		img = Toolkit.getDefaultToolkit().getImage("res/upBread.png");
	}
	
	public Bread()
	{
		x = 300;
		y = 0;
	}
	

	
	public void move(int maxY) 
	{
		// 떨어지는 간격(속도)
		if(y<maxY)
			y+=5; 
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

	public void remove() 
	{
		
	}

	
	
	
}
