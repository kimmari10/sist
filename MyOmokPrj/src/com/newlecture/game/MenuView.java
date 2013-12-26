package com.newlecture.game;

import java.util.Scanner;

public class MenuView {

		public void print()
		{
			System.out.println("1. 1인용\n2. 순위보기\n3. 종료하기");
		}

		int input()
		{
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			return menu;
		
		}
		
	
}
