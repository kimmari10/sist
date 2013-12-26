package game.manager;

import game.protocol.IDrawable;

import java.awt.Graphics;
import java.util.ArrayList;

public class BurgerManager {
	ArrayList<IDrawable> mItemes; //��ξ�� �ڷ����� ��̸���Ʈ 
	
	
	public BurgerManager()  //������
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
	
	
	public void move() //����̵�
	{
		for(int i=0;i<mItemes.size();i++){
			mItemes.get(i).move(468 - (i * 15));
		}
	}
	
	public void add(IDrawable drawable) //����߰�
	{
		mItemes.add(drawable);
	}
	
	public void paint(Graphics g) //���׸���
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
