package ����;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ������ extends JFrame{
	private ������ư btnOk;
	private Image img;
	
	
	public ������() 
	{
		setSize(500, 600);
		setLayout(null);
		btnOk = new ������ư("Ȯ��");
		btnOk.setBounds(100, 100, 100, 50);
		add(btnOk);
		
		img = Toolkit.getDefaultToolkit().getImage("res/bgimg.png");
		
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(img, 0, 0, this);
		
		btnOk.repaint();
	}

}