package role;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{

	private ChatGamePanel gamePanel;
	
	private JMenu mnTool;
	private JMenuItem miToolStart;
	private JMenuItem miToolConn;
	private JMenuBar mainMenu;
	
	public MainFrame()
	{
		mainMenu = new JMenuBar();
		mnTool = new JMenu("도구");
		miToolStart = new JMenuItem("시작");
		miToolStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
					gamePanel.svrStart();
			}
		});
		
		miToolConn = new JMenuItem("연결");
		miToolConn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
					
					gamePanel.svrConn();
			}
		});
		

		mnTool.add(miToolStart);
		mnTool.add(miToolConn);
		mainMenu.add(mnTool);
		setJMenuBar(mainMenu);
		
		
		setSize(500, 500);
		gamePanel = new ChatGamePanel();

		add(gamePanel);
		
		
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) 
			{
				
				System.exit(0);
			}
			
		});
		
	}
	
	
}
