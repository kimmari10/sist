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
		// �ܹ��� ����
		x= 720;
		y= 250; 
	}

	//����Ʈ �ʿ����

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
		// ��Ƽ ���� ��ġ ����
		Patty pt = new Patty();
		
		pt.setX(x+50);
		pt.setY(y);
		
		return pt;
	}
	
	public Lettuce fire2()
	{
		// ��Ƽ ���� ��ġ ����
		Lettuce lt = new Lettuce();
		
		lt.setX(x+50);
		lt.setY(y);
		
		return lt;
	}
	
	
	public Cheese fire3()
	{
		// ��Ƽ ���� ��ġ ����
		Cheese cs = new Cheese();
		
		cs.setX(x+50);
		cs.setY(y);
		
		return cs;
	}
	
	public Bread fire4()
	{
		// ��Ƽ ���� ��ġ ����
		Bread bd = new Bread();
		
		bd.setX(x+50);
		bd.setY(y);
		
		return bd;
	}
	
}
