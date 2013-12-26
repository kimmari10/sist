package collection;

import collection.ObjectCollection.ObjectIterator;

public class Program2  {
	
	public static void main(String[] args)
	{
		final ObjectCollection list = new ObjectCollection();//¿Ö final?
		
		
		for(int i=0; i<11100; i++)
			list.add(i+1);
		
		new Thread(new Runnable() {
			
			public void run() {
				printList(list);
			}
		}).start();
		
		list.add("hello");
		list.add(3.5);
		list.add(new EnemyMissile());
		
//		for(int i=0; i<list.size(); i++)
//			System.out.println(list.equals(i));

		
//		ObjectIterator it = list.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
		for(Object o : list)
			System.out.println(o);
		
	}

	private static void printList(ObjectCollection list) 
	{
		
//		ObjectIterator it = list.iterator();
//		while(it.hasNext())
//		System.out.println("printList : "+ it.next());
		
		for(Object o : list)
			System.out.println("@"+o);
	}

}

