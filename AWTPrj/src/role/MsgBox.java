package role;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MsgBox extends GameItem{
	
	private Image img;
	private String msg;
	private GameBoard parent;
	private int width;

	
	
	public int getWidth() 
	{
		return width;
	}


	public void setWidth(int width) 
	{
		this.width = width;
	}


	public MsgBox()
	{
		msg = "";
		img = Toolkit.getDefaultToolkit().getImage("res/msg.png");
	}
	
	
	public void paint(Graphics g) 
	{
		int x = getX();
		int y = getY();
		
		g.setColor(Color.red);
		g.fillRect(x, y, width+20, 40);
		
		g.setColor(Color.yellow);
		g.drawRect(x, y, width+20, 40);
		
		g.setFont(new Font("±¼¸²", Font.BOLD, 40));
		
		g.setColor(Color.black);
		g.drawString(msg , x+10, y+40);
		
		
		//g.drawImage(img, x, y, parent);
	}


	public String getMsg() 
	{
		return msg;
	}


	public void setMsg(String msg) 
	{
		this.msg = msg;
	}

}
