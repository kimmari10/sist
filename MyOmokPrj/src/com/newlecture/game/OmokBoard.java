package com.newlecture.game;

public class OmokBoard {
	
	private char [][]buf;  

	public OmokBoard() 
	{
		buf = new char[30][40];
		
		for(int i=0; i<30; i++)
			for(int j=0; j<40; j++)
				buf[i][j] = '¦«';
		
	}
	
	public void print()
	{
		for(int i=0; i<30; i++)
		{
			for(int j=0; j<40; j++)
				System.out.printf("%c",  buf[i][j]);
			System.out.println();
		}
	}
}
