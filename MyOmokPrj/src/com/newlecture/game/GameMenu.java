package com.newlecture.game;

import java.util.Scanner;

public class GameMenu {

	public void print() 
	{
		System.out.println("1. ����α�\t2. �Ѽ�����\t3. ����\t4. �����ϱ�");
	}
	
	public int input()
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}

}
