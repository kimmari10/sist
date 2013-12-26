package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		/*
		ServerSocket svrSock = new ServerSocket(10001);
		System.out.println("-----------서버를 가동합니다...---------------");
		
		Socket sock = svrSock.accept();
		System.out.printf("connected from... %s\n",sock.getRemoteSocketAddress());
		
		OutputStream os = sock.getOutputStream();
		InputStream is = sock.getInputStream();
		
		PrintWriter nout = new PrintWriter(os,true);
		Scanner nscan = new Scanner(is);
		Scanner scan = new Scanner(System.in);
		
		
		while(true)
		{
			System.out.print("나 : ");
			String msg = scan.nextLine();
			nout.println(msg);
			
			String ans = nscan.nextLine();
			System.out.printf("상대방 : %s\n",ans);
		}*/
		
	}

}
