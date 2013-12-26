package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static MainFrame getIns;
	
//	---------윈도우들----------
	private GameBoard board;
	private Help help;
	private GameOver gameOver;
	private StartImage stm;
	
	 Clip clip;
	
	static
	{
		getIns = null;
	}
	
	public static MainFrame getIns()
	{
		if(getIns == null)
			getIns = new MainFrame();
		
		return getIns;
	}
	
	public MainFrame()
	{
		
		help = new Help();
		gameOver = new GameOver();
		board = new GameBoard();
		stm = new StartImage(); //시작 이미지 추가
		
		this.add(help);
		this.add(gameOver);
		this.add(board);
		this.add(stm);
		
	    stm.setVisible(true);
		
	    change(BoardType.stm);
	    
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent arg0)
			{
				System.exit(0);
			}
			
		});
	} 
//	----------------------생성자끝-------------------
	
	public void change(BoardType type) // 화면전환함수
	{
		switch(type)
		{
		case board:          // 겜시작
			board.setTimeX(800);
			board.setScore(0);
			add(board);
			remove(help);
			remove(gameOver);
			remove(stm);
			board.start();
			break;
			
		case gameOver :   // 겜오버 화면
			add(gameOver);
			remove(board);
//			Sound("res/music/leshphon.wav", true);	 // 게임오버 배경음악
			break;
			
		case help:             //도움말 화면
			add(help);
			remove(stm);
			break;
			
		case stm:            //시작화면
//			clip.close();
			board.setFocusable(true);  
			add(stm);
			remove(help);
			break;
		}
		
		this.revalidate();
		
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
	}
	
	
//	private void Sound(String file, boolean Loop) { //소리재생 함수
//		try {
//			AudioInputStream ais = AudioSystem
//					.getAudioInputStream(new BufferedInputStream(
//							new FileInputStream(file)));
//			clip = AudioSystem.getClip();
//			clip.open(ais);
//			clip.start();
//			if (Loop)
//				clip.loop(-1);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
