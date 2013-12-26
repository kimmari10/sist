package server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	
	private JMenuBar mainMenu;
	private JMenu mnServer;
	private JMenuItem miServerStart;
	
	private ServerSocket svrSock;
	private Socket sock;
	
	private PrintWriter out;
	private Scanner scan;
	
	private JTextArea txtOutput;
	private JTextArea txtInput;
	
	private JButton btnSend;
	private JPanel panel;
	
	public MainFrame() {
		setSize(500, 600);

		mainMenu = new JMenuBar();
		mnServer = new JMenu("서버");
		miServerStart = new JMenuItem("서버시작");
		miServerStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							svrSock = new ServerSocket(10001); 
							
							txtOutput.setText("서버시작\r\n");
							
							sock = svrSock.accept(); // 별도 쓰레드에서 돌리지 않으면 블로킹으로 쓰레드 먹어버려서 멈춤
							String txt = txtOutput.getText();
							txt += "connected from" + sock.getRemoteSocketAddress();
							txtOutput.setText(txt);
							
							out = new PrintWriter(sock.getOutputStream(),true);
							scan = new Scanner(sock.getInputStream());
							
							
							while(true)
							{
								//데이터를 읽는 루프
								String msg = scan.nextLine();
								String str = txtOutput.getText()+"\r\n";
								txtOutput.setText(str+msg);
							}

						} catch (Exception e2) {	
							e2.printStackTrace();
						}

					}
				}).start();
				
			}
		});
		
		mnServer.add(miServerStart);
		mainMenu.add(mnServer);
		setJMenuBar(mainMenu);
		
		
		
		

		setSize(300,700);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1,50));
		panel.setBorder(BorderFactory.createLineBorder(Color.green));
		
		txtInput = new JTextArea();
		txtOutput = new JTextArea();
		
		btnSend = new JButton("전송");
		btnSend.setPreferredSize(new Dimension(100,1));
		btnSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String msg = txtInput.getText();
				String str = txtOutput.getText()+"\r\n";
				txtOutput.setText(str+"나 : " +msg+"\n");
				out.println(msg);
				
			}
		});
		
		
		
		panel.setLayout(new BorderLayout());
		
		panel.setLayout(new BorderLayout());
		panel.add(btnSend, BorderLayout.EAST);
		panel.add(txtInput, BorderLayout.CENTER);
		
		
		//메인에 붙일 윈도우 추가
		setLayout(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		add(txtOutput, BorderLayout.CENTER);
		
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) 
			{
				
				System.exit(0);
			}
			
		});
		
		
		
	}

}
