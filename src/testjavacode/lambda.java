package testjavacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> names =  new ArrayList();
		List<String> names =  new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Rama");
		names.add("Aditya");
		names.add("Shravana");
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
		long d=Stream.of("Abhijeet","Ram","Shrava").filter(s->
		{
		s.startsWith("A");
		return false;
		}).count();
		System.out.println(d);
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//sort
		List<String> name1 =  Arrays.asList("Abhijeet","Ram","Shrava");
		name1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
		}
	}


