package collection;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



public class SplashBoard extends Canvas{
	
	private static Image img;
	

	static
	{
		img = Toolkit.getDefaultToolkit().getImage("res/splash.png");
	}
	
	public SplashBoard()
	{
		
	}

	public void paint(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(img, 0, 0, this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
