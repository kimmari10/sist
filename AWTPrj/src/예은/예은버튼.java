package ����;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;

public class ������ư extends JButton{
	
	private Image img;
	
	public ������ư(String caption) 
	{
		super(caption);
		
		img = Toolkit.getDefaultToolkit().getImage("res/bgimg.png");
	}
	
	@Override
	public void paint(Graphics g) 
	{		
		g.drawImage(img, 0, 0, this);
	}

}
