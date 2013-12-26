package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
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

public class GameOver extends Canvas{
	
	private Image img;
	private GameBoard gameBoard;
	private int score;
	private Clip clip;

	public GameOver() {
		
		
		gameBoard = new GameBoard();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/gameOver.png"); // 이미지 불러오는거

		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent m) 
			{
				if(m.getX()>0 && m.getX()<300)  // 다시하기 미구현 - 좌표새로
				{	
					if(m.getY()>450 && m.getY()<650)
					{
						MainFrame.getIns().change(BoardType.board);
					}
				}
				else if(m.getX()>750 && m.getX()<950) // 겜끄기 - 좌표새로좀
				{
					if(m.getY()>450 && m.getY()<650)
					{
						System.exit(0);
					}
				}
			}
			
		});
		
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.setFont(new Font("기본", Font.BOLD,  50));
		g.setColor(Color.RED);
		g.drawImage(img,0, 0, this);
		g.drawString("Score : "+ Integer.toString(gameBoard.score), 650, 150);
//		g.drawString("Score : "+ Integer.toString(gameBoard.score), 20, 550);
	}
	
	
}
	
	

