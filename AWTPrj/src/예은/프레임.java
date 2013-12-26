package 예은;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class 프레임 extends JFrame{
	private 예은버튼 btnOk;
	private Image img;
	
	
	public 프레임() 
	{
		setSize(500, 600);
		setLayout(null);
		btnOk = new 예은버튼("확인");
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