package role;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class GameItem{
	
	private int x;
	private int y;
	protected Image img;  //protected - 자식에게만 공개할수 있는 접근자
	private GameBoard parent;
	
	public GameItem()
	{
		this(0, 0,  null);
	}
	
	public GameItem(int x, int y, GameBoard parent)
	{
		this.x=x;
		this.y=y;
		this.parent = parent;
		
	}
	
	public abstract void paint(Graphics g);

	
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

	public GameBoard getParent() {
		return parent;
	}

	public void setParent(GameBoard parent) {
		this.parent = parent;
	}
	
	
	

}
