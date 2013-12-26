package 민호;

import javax.swing.JFrame;

public class 프레임 extends JFrame{

	private 게임보드 _게임보드;
	private 랭킹보드 _랭킹보드;
	private static 프레임 getInstance;
	
	
	static
	{
		getInstance = null;
	}
	
	public static 프레임 getInstance()
	{
		if(getInstance == null)
			getInstance = new 프레임();
		
		return getInstance;
	}
	
	public 프레임() 
	{
		setSize(500,600);
		
		_게임보드 = new 게임보드();
		_랭킹보드 = new 랭킹보드();
		
		add(_게임보드);
		add(_랭킹보드);
		
		보드변경(보드타입.게임보드);
	}
	
	public void 보드변경(보드타입 _타입)
	{
		remove(_랭킹보드);
		remove(_게임보드);
		
		switch(_타입)
		{
		case 게임보드 :
			add(_게임보드);
			break;	
		case 랭킹보드 :
			add(_랭킹보드);
			break;
		}
		
		this.revalidate();
		
	}
	
	
}
