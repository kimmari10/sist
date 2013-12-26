package collection;

import java.util.Iterator;


public class GCollection<현상> implements Iterable<현상>{ //ArrayList
	
	private int current;
	private int max;
	private 현상[] enemies;

	
	public GCollection () 
	{
		current = 0;
		max = 3;
		enemies = (현상[]) new Object[max]; 
	}
	
	public void add(현상 en)
	{
		if(current >= max)
		{
			/*
			 * 공간을 늘려주는코드
			 * 1. 배열을 temp라는 이름으로 max+10만큼의 배열을 새로 생성
			 * 2. enemies 
			 */
			
			현상[] temp = (현상[]) new Object [max+10];
			
			for(int i=0; i<max; i++)
				temp[i]= enemies[i];
			
			enemies = temp;
			max += 10;
			
			
		}
		this.enemies[current++] = en;
	}
	
	public 현상 get(int idx)
	{
		return enemies[idx];
	}
		
	public int size()
	{
		return current;
	}

	public void remove(현상 ef) //컬렉션 클래스 remove 알고리즘
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
			enemies[idx+i]=enemies[idx+i+1];//ㅇㅇ;;
		current--;
	}

	
	
	
	public ObjectIterator<현상> iterator()
	{
		return new ObjectIterator();
	}
	
	
	class ObjectIterator<현상> implements Iterator<현상>
	{
		private int idx= -1;
		
//		public void reset()
//		{
//			idx = -1;
//		}
		
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
	
		public 현상 next() 
		{
			return (현상)enemies[idx];
		}

		public void remove() {
			
		}
	}

}
