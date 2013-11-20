import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
//		System.out.println("넓이를 입력해주세요");
		int width = 800;//scan.nextInt();
//		System.out.println("높이를 입력해주세요");
		int height= 500;//scan.nextInt();
//		scan.nextLine();
//		System.out.println("이름을 입력해주세요");
		String name = "종성";//scan.nextLine();
		
		String w = req.getParameter("w");
		String h = req.getParameter("h");
		String n = req.getParameter("n");
		
		if(w != null)
			width = Integer.parseInt(w);
		
		if(h != null)
			height = Integer.parseInt(h);
		
		if(n != null)
			name = n;
		
		
		
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		


		
		
		Graphics g = img.getGraphics();
		
		Image bg = Toolkit.getDefaultToolkit().getImage("C:\\workspace\\JSPPrj\\res\\11.JPG");
		

		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("궁서", Font.BOLD, 30));
		
		g.drawImage(bg, 0	, 0, null);
		g.drawLine(10, 10, 20, 120);
		g.drawString(name, 300, 100);
		
		JPEGImageEncoder encoder = 
				JPEGCodec.createJPEGEncoder(resp.getOutputStream());
		
		encoder.encode(img);
//		System.out.println("출력완료");
		
	}
	

	
}
