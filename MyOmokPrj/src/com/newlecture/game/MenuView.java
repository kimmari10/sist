package com.newlecture.game;

import java.util.Scanner;

public class MenuView {

		public void print()
		{
			System.out.println("1. 1�ο�\n2. ��������\n3. �����ϱ�");
		}

		int input()
		{
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			return menu;
		
		}
		
	
}
