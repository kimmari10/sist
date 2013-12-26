package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
/*		Socket sock = new Socket("211.238.142.188", 10001); 
		System.out.printf("connected to %s\n", sock.getRemoteSocketAddress());
		
		OutputStream os = sock.getOutputStream();
		InputStream is = sock.getInputStream();
		
		Scanner nscan = new Scanner(is);
		Scanner scan = new Scanner(System.in);
		
		//System.out.println(scan.nextLine());
		
		PrintWriter nout = new PrintWriter(os, true); 
		

		

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
