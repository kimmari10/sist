package com.newlecture.game;

public class Program {

	public static void main(String[] args) 
	{
		MenuView menuView = new MenuView();
		GameView gameView = new GameView();
		RankingView rankingView = new RankingView();
		
		menuView.print();
		int menu = menuView.input();
		
		switch(menu)
		{
			case 1 :
				gameView.print();
				
				break;
				
			case 2 :
				break;
				
			case 3 :
				break;
		
		}
	
	}

}
