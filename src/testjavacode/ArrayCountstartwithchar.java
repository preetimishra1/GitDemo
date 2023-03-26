package testjavacode;

import java.util.ArrayList;

public class ArrayCountstartwithchar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> names =  new ArrayList();
		names.add("Abhijeet");
		names.add("Ram");
		names.add("Aditya");
		names.add("Shravan");
		names.add("Abhijeet");
		/*int count =0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
				
			}
					
		}*/
		//lambda expression
		
		long name= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(name);
		//System.out.println(count);
		
		
	}

}
