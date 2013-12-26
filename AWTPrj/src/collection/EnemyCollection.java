package collection;

public class EnemyCollection {
	
	private int current;
	private int max;
	private EnemyFighter[] enemies;
	private int idx;

	
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
			 * ������ �÷��ִ��ڵ�
			 * 1. �迭�� temp��� �̸����� max+10��ŭ�� �迭�� ���� ����
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

	public void remove(EnemyFighter ef) //�÷��� Ŭ���� remove �˰���
	{
		int idx =0;
		for(int i=0; i<size(); i++)
		{
			if(enemies[i] == ef)
				break;
			else
				idx++;
		}
		for(int i=0; i<size()-idx; i++)
			enemies[idx+i]=enemies[idx+i+1];//����;;
		current--;
	}
	
	
	
	public void reset()
	{
		idx = -1;
	}
	
	public boolean hasNext() 
	{
	
		idx++;
		if(idx<current)
		{
			return true;
		}
		else
			return false;
	}

	public Object next() 
	{
		return enemies[idx];
	}

	public void remove() {
		
	}
	

}
