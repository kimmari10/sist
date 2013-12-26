package game;


public class Program {

	public static void main (String[] args)
	{
		MainFrame fm = MainFrame.getIns();
		
		fm.setVisible(true);
		fm.setSize(1000,600); 
		
		GameBoard board = new GameBoard();
		
		
	}
	
}
