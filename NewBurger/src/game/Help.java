package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Help extends Canvas{
	
	private Image img;
	
	public Help() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/help.png"); 
		
		addMouseListener(new MouseAdapter() {
			
			
			public void mousePressed(MouseEvent m) 
			{

			}
			
			
			public void mouseClicked(MouseEvent m) 
			{
				if(m.getX()>0 && m.getX()<300)  // 스타트이미지 버튼 위치 //좌표새로해야함
				{	
					if(m.getY()>450 && m.getY()<650)
					{
						MainFrame.getIns().change(BoardType.stm);
						
					}
				}
				else if(m.getX()>750 && m.getX()<950) // 겜바로시작 // 좌표새로해야함
				{
					if(m.getY()>450 && m.getY()<650)
					{
						MainFrame.getIns().change(BoardType.board);
					}
				}
			}
			
		});
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img,0, 0, this);
	} 
	
	
}