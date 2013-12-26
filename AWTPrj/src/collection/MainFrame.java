package collection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

	//Frame 업글버전의 JFrame 사용
	
	
	private SplashBoard splashBoard;
	private GameBoard board;
	//private RankingBoard rankingBoard;
	
	private JMenuBar mainMenu;
	
	private JMenu mnFile;
	private JMenu mnWindow;
	
	
	private JMenuItem miWindowSplash;
	private JMenuItem miWindowGame;
	
	private JMenuItem miFileExit;
	
	public MainFrame()
	{
		
		
		//-------------------------------------
		
		mainMenu = new JMenuBar();
		mnFile = new JMenu("파일");
		mnWindow = new JMenu("창");
		
		
		miWindowSplash = new JMenuItem("스플래쉬");
		miWindowSplash.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.pause();
				MainFrame.this.remove(board);
				MainFrame.this.add(splashBoard);
				MainFrame.this.revalidate();
				
			}
		});
		
		miWindowGame = new JMenuItem("게임");
		miWindowGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainFrame.this.remove(splashBoard);  //프레임add, remove와 visibable의 차이?...
				MainFrame.this.add(board);

				MainFrame.this.revalidate();
				board.start();
				//board.setFocusable(true);
			}
		});
		
		miFileExit = new JMenuItem("종료");
		miFileExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		
		//---------------------------------------
		
		mnWindow.add(miWindowSplash);
		mnWindow.add(miWindowGame);
		
		mnFile.add(miFileExit);
		
		
		mainMenu.add(mnFile);
		mainMenu.add(mnWindow);

		
		this.setJMenuBar(mainMenu);
		
		//----------------------------------------
		
		setSize(500,700);
		
		
		board = new GameBoard();
		board.setFocusable(true);
		this.add(board);
		
		splashBoard = new SplashBoard();
		splashBoard.setFocusable(true);
		this.add(splashBoard);
		
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) 
			{
				System.exit(0);
			}
			
		});
		
	}
	
}
