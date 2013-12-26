package shooting;

public class EnemyCollection {
	
	private int current;
	private int max;
	private EnemyFighter[] enemies;

	
	public EnemyCollection() {
		current = 0;
		max = 3;
		enemies = new EnemyFighter[max]; 
		
		
		
		
	}
	
	public void add(EnemyFighter en)
	{
		if(current >= max)
		{
			/*
			 * 공간을 늘려주는코드
			 * 1. 배열을 temp라는 이름으로 max+10만큼의 배열을 새로 생성
			 * 2. enemies 
			 */
			
			EnemyFighter[] temp = new EnemyFighter [max+10];
			
			for(int i=0; i<max; i++)
				temp[i]= enemies[i];
			
			enemies = temp;
			max += 10;
			
			
		}
		this.enemies[current++] = en;
	}
	
	public EnemyFighter get(int idx)
	{
		return enemies[idx];
	}
		
	public int size()
	{
		return current;
	}


}
