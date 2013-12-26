package role;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Man extends GameItem{

	private int type;
	private Image img;
	
	private int speed;
	private int timer;
	private int offSetY;
	private int offSetX;
	
	private boolean left;
		
	public static final int hostType = 1;
	public static final int friendType = 2;
		
	
	public Man()
	{
		this(0, 0, hostType, null);
	}
	
	public Man(int x, int y, int type, GameBoard parent)
	{
		super(x, y, parent);
		//if(type == hostType)
			this.img =Toolkit.getDefaultToolkit().getImage("res/man.png");
		
		/*else
			this.img =Toolkit.getDefaultToolkit().getImage("");*/
		
		speed = 5;
		timer = 10;
		offSetX= 106*1;
		offSetY= 148*2;
		left = true;
		this.type = type;
	}
	
	public void paint(Graphics g) 
	{
		int x = getX();
		int y = getY();
		
		
		int w=106;
		int h=148;
		
		GameBoard parent = getParent();
		g.drawImage(img, x, y, x+106/2, y+148/2, offSetX, offSetY, offSetX+106, offSetY+148, parent );
		
		if(type == friendType)
		{
			g.setColor(Color.white);
			g.drawRect(x, y,  w/2, h/2);
		}
	}

	public void walk(int h, int v) 
	{
		int x = getX();
		int y = getY();
		
		
		if(timer -- == 0)
		{
			offSetX = 106 * (left  ? 0 : 2);
			left = !left;
			timer=10;
			
		}

		switch(h)
		{
		case KeyEvent.VK_LEFT :
			
			offSetY=148*3;
			x -= speed;
			break;
		case KeyEvent.VK_RIGHT :
			
			offSetY=148;
			x += speed;
			break;
		}
		
		switch(v)
		{
		case KeyEvent.VK_UP :
			
			offSetY=0;
			y -= speed;
			break;
		case KeyEvent.VK_DOWN :

			offSetY=148*2;
			y += speed;
			break;
		}
		setX(x);
		setY(y);
	}
	
	public void stop()
	{
		offSetX = 106;
	}

	public int getType() {
		return type;
	}

	public void setType(int tpye) {
		this.type = type;
	}
	
	

}
