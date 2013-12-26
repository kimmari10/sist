package com.newlecture.game;

import java.util.Scanner;


public class GameView 
{

	private OmokBoard board;
	private StatusBar statusBar;
	private GameMenu menu;
	
	
	public GameView() 
	{
		board = new OmokBoard();
		statusBar = new StatusBar();
		menu = new GameMenu();
		
	}
	
	
	public void print()
	{
		board.print();
		statusBar.print();
		menu.print();
	}
	
	
	
	
	
	
}
