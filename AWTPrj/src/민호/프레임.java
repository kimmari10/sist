package ��ȣ;

import javax.swing.JFrame;

public class ������ extends JFrame{

	private ���Ӻ��� _���Ӻ���;
	private ��ŷ���� _��ŷ����;
	private static ������ getInstance;
	
	
	static
	{
		getInstance = null;
	}
	
	public static ������ getInstance()
	{
		if(getInstance == null)
			getInstance = new ������();
		
		return getInstance;
	}
	
	public ������() 
	{
		setSize(500,600);
		
		_���Ӻ��� = new ���Ӻ���();
		_��ŷ���� = new ��ŷ����();
		
		add(_���Ӻ���);
		add(_��ŷ����);
		
		���庯��(����Ÿ��.���Ӻ���);
	}
	
	public void ���庯��(����Ÿ�� _Ÿ��)
	{
		remove(_��ŷ����);
		remove(_���Ӻ���);
		
		switch(_Ÿ��)
		{
		case ���Ӻ��� :
			add(_���Ӻ���);
			break;	
		case ��ŷ���� :
			add(_��ŷ����);
			break;
		}
		
		this.revalidate();
		
	}
	
	
}
