package role;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatGamePanel extends JPanel{

	private JTextArea txtInput;
	private JButton btnSend;
	private JPanel chatPanel;
	private Socket sock;
	private ServerSocket svrSock;
	private Scanner scan;
	private PrintWriter nout;
	
	private GameBoard gameBoard;
	
	public ChatGamePanel()
	{
		
		gameBoard = new GameBoard();
		//gameBoard.setLocation(0, 0);
		//gameBoard.setSize(500, 500);

		
		chatPanel = new JPanel();
		chatPanel.setPreferredSize(new Dimension(1,50));

		txtInput = new JTextArea();
		//txtInput.setPreferredSize(new Dimension(1,50)); 
		//txtInput.setLocation(0,500);
		//txtInput.setSize(400,50);
		
		btnSend = new JButton("전송");
		btnSend.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)  // 전송버튼 누를경우 실행
			{
				String msg = txtInput.getText();
				gameBoard.showMessage(msg);
				//JOptionPane.showMessageDialog(ChatGamePanel.this, msg);
				
			}
		});
		//btnSend.setLocation(400, 500);
		//btnSend.setSize(100, 50);

		setLayout(new BorderLayout()); //ChatGamePanel 레이아웃 다시하기
		
		gameBoard.setFocusable(true);
		
		
		chatPanel.setLayout(new BorderLayout()); //ChatPanel 레이아웃 다시하기
		chatPanel.add(txtInput, BorderLayout.CENTER);
		chatPanel.add(btnSend, BorderLayout.EAST);

		add(gameBoard, BorderLayout.CENTER);
		add(chatPanel, BorderLayout.SOUTH);
		
		gameBoard.start();
	}
	
	public void svrStart()  // ----------------서버---------------
	{
			new Thread(new Runnable() {
				
				public void run() {
					
					try {
						svrSock = new ServerSocket(10001);
						sock = svrSock.accept();
						
						nout = new PrintWriter(sock.getOutputStream(),true);
						scan = new Scanner(sock.getInputStream());
						
						gameBoard.setOut(nout);						
						gameBoard.setScan(scan);					

						gameBoard.hasJoined();
						
						//데이터수신
						while(true)
						{
							scan.nextLine();
						}
							
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}).start();

	}
	
	public void svrConn()  // ---------------클라이언트--------------
	{
		new Thread(new Runnable() {
			
			public void run() {
				try {
					
					sock = new Socket("211.238.142.188",10001);
					
					nout = new PrintWriter(sock.getOutputStream(),true);
					scan = new Scanner(sock.getInputStream());
					
					gameBoard.setOut(nout);						
					gameBoard.setScan(scan);
					
					//데이터수신
					while(true)
					{
						String data = scan.nextLine();
						String[] pos = data.split(" ");
						
						int x = Integer.parseInt(pos[0]);
						int y = Integer.parseInt(pos[1]);
						
						Man friend = new Man(x, y, Man.friendType, gameBoard);
						gameBoard.addMan(friend);
					}
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
			
			
	}
}
