package shooting;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class UserFighter extends Canvas {

	private UserMissile[] usermissiles;
	private int x;
	private int y;
	private Image img;
	private int speed;
	
	public UserFighter()
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/user.jpg");
		
		usermissiles = new UserMissile[10];
		
		x = 200;
		y = 300;
		speed = 5;
	}

	public void paint(Graphics g, GameBoard parent) {
		
		g.drawImage(img, x, y, parent);
		
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

	public void move(int key) {
		
		
		switch(key)
		{
			case KeyEvent.VK_LEFT:
				if(x>=0)
					x -= speed;
				break;
			case KeyEvent.VK_RIGHT:
				if(x<=330)
					x += speed;
				break;
				
			case KeyEvent.VK_UP:
				if(y>=0)
					y -= speed;
				break;
			case KeyEvent.VK_DOWN:
				if(y<=440)	
					y += speed;
				break;
		}
		
	}

	public UserMissile fire() 
	{
		UserMissile um = new UserMissile(); 
		um.setX(this.x+25);
		um.setY(this.y-40);
		
		return um;
	}
	
/*	public void shoot(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(bg, 0, 0, this);
		usermissiles.paint(g,this);
	}
	*/

}
