package 민호;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class 게임보드 extends Canvas {
	
	private int count;
	
	public 게임보드() 
	{
		count=3;
		
		addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(게임보드.this, "test");
				new Thread(new Runnable() {
					
					@Override
					public void run() 
					{
						while(true)
						{
							repaint();
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							if(count ==0)
							{
								프레임.getInstance().보드변경(보드타입.랭킹보드);
								break;
							}
							count--;
						}
					}
				}).start();
				
			}
			
		});
	
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color. blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawString(String.valueOf(count),100,100);
	}
}
