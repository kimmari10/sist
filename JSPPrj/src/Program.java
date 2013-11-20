import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class Program {

	public static void main(String[] args) throws ImageFormatException, IOException 
	{
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("넓이를 입력해주세요");
		int width = 500;//scan.nextInt();
//		System.out.println("높이를 입력해주세요");
		int height= 500;//scan.nextInt();
//		scan.nextLine();
//		System.out.println("이름을 입력해주세요");
		String name = "종성";//scan.nextLine();
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		


		
		
		Graphics g = img.getGraphics();
		
		Image bg = Toolkit.getDefaultToolkit().getImage("res/11.jpg");
		

		g.setColor(Color.yellow);
		g.setFont(new Font("궁서", Font.BOLD, 30));
		
		g.drawLine(10, 10, 20, 120);
		g.drawString(name, 100, 100);
		g.drawImage(bg, 0, 0, null);
		
		JPEGImageEncoder encoder = 
				JPEGCodec.createJPEGEncoder(Response.getOutputStram());
		
		encoder.encode(img);
//		System.out.println("출력완료");
		
	}

}
