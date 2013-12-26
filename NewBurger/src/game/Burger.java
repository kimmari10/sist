package game;

import java.awt.Canvas;

public class Burger extends Canvas{

	private Patty patty;
	private Lettuce lettuce;
	private Cheese cheese;
	private Bread bread;
	
	private int x;
	private int y;
	
	public Burger()
	{
		// 햄버거 위쪽
		x= 720;
		y= 250; 
	}

	//페인트 필요없음

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Patty fire1()
	{
		// 패티 쌓을 위치 지정
		Patty pt = new Patty();
		
		pt.setX(x+50);
		pt.setY(y);
		
		return pt;
	}
	
	public Lettuce fire2()
	{
		// 패티 쌓을 위치 지정
		Lettuce lt = new Lettuce();
		
		lt.setX(x+50);
		lt.setY(y);
		
		return lt;
	}
	
	
	public Cheese fire3()
	{
		// 패티 쌓을 위치 지정
		Cheese cs = new Cheese();
		
		cs.setX(x+50);
		cs.setY(y);
		
		return cs;
	}
	
	public Bread fire4()
	{
		// 패티 쌓을 위치 지정
		Bread bd = new Bread();
		
		bd.setX(x+50);
		bd.setY(y);
		
		return bd;
	}
	
}
