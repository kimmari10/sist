package ��ȣ;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class ���Ӻ��� extends Canvas {
	
	private int count;
	
	public ���Ӻ���() 
	{
		count=3;
		
		addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(���Ӻ���.this, "test");
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
								������.getInstance().���庯��(����Ÿ��.��ŷ����);
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
