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

public class StartImage extends Canvas{
	
	private Image img;
	private Clip clip;
	
	public StartImage() 
	{
		
		Sound("res/music/gameSound.wav", true); // ����ȭ�� �������
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/mainSample.png"); // �̹��� �ҷ����°�

		addMouseListener(new MouseAdapter() {
			
			
			public void mousePressed(MouseEvent m) 
			{

			}
			
			
			public void mouseClicked(MouseEvent m) 
			{
				if(m.getX()>745 && m.getX()<858)  // �׽��� 
				{	
					if(m.getY()>88 && m.getY()<182)
					{
						clip.close();
						MainFrame.getIns().change(BoardType.board);
					}
				}
				else if(m.getX()>380 && m.getX()<473) // ���� ����
				{
					if(m.getY()>146 && m.getY()<230)
					{
						MainFrame.getIns().change(BoardType.help);
					}
				}
			}
			
		});
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img,0, 0, this);
	}
	
	private void Sound(String file, boolean Loop) { //�Ҹ���� �Լ�
		try {
			AudioInputStream ais = AudioSystem
					.getAudioInputStream(new BufferedInputStream(
							new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if (Loop)
				clip.loop(-1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}