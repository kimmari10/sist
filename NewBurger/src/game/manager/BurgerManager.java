package game.manager;

import game.protocol.IDrawable;

import java.awt.Graphics;
import java.util.ArrayList;

public class BurgerManager {
	ArrayList<IDrawable> mItemes; //드로어블 자료형의 어레이리스트 
	
	
	public BurgerManager()  //생성자
	{
		mItemes = new ArrayList<IDrawable>();
	}
	
	public int size()
	{
		return mItemes.size();
	}
	
	public int getY()
	{
		return mItemes.get(size()-1).getY();
	}
	
	
	public void move() //재료이동
	{
		for(int i=0;i<mItemes.size();i++){
			mItemes.get(i).move(468 - (i * 15));
		}
	}
	
	public void add(IDrawable drawable) //재료추가
	{
		mItemes.add(drawable);
	}
	
	public void paint(Graphics g) //재료그리기
	{
		for(IDrawable Drawable : mItemes)
			Drawable.paint(g);
	}
	
	public void reMove(){
		for(int i=0; i < mItemes.size(); i++)
		{
				mItemes.clear();
		}
	}
	
}
