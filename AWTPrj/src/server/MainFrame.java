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
		mnServer = new JMenu("����");
		miServerStart = new JMenuItem("��������");
		miServerStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							svrSock = new ServerSocket(10001); 
							
							txtOutput.setText("��������\r\n");
							
							sock = svrSock.accept(); // ���� �����忡�� ������ ������ ���ŷ���� ������ �Ծ������ ����
							String txt = txtOutput.getText();
							txt += "connected from" + sock.getRemoteSocketAddress();
							txtOutput.setText(txt);
							
							out = new PrintWriter(sock.getOutputStream(),true);
							scan = new Scanner(sock.getInputStream());
							
							
							while(true)
							{
								//�����͸� �д� ����
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
		
		btnSend = new JButton("����");
		btnSend.setPreferredSize(new Dimension(100,1));
		btnSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String msg = txtInput.getText();
				String str = txtOutput.getText()+"\r\n";
				txtOutput.setText(str+"�� : " +msg+"\n");
				out.println(msg);
				
			}
		});
		
		
		
		panel.setLayout(new BorderLayout());
		
		panel.setLayout(new BorderLayout());
		panel.add(btnSend, BorderLayout.EAST);
		panel.add(txtInput, BorderLayout.CENTER);
		
		
		//���ο� ���� ������ �߰�
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
