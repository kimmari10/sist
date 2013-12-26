package com.newlecture.game;

import java.util.Scanner;

public class GameMenu {

	public void print() 
	{
		System.out.println("1. 오목두기\t2. 한수봐줘\t3. 도움말\t4. 포기하기");
	}
	
	public int input()
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}

}
