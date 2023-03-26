package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.testng.annotations.Test;

import org.testng.Assert;

public class MergeArrayListLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				List<String> name1 =  new ArrayList<String>();
		name1.add("Abhijeet");
		name1.add("Rama");
		name1.add("Aditya");
		name1.add("Shravana");
		name1.add("Abhijeet");
		
		List<String> name2 =  Arrays.asList("Abhimana","Kalyana","Shrava");
		
		Stream<String> newstream = Stream.concat(name1.stream(), name2.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		 boolean flag = newstream.anyMatch(s->s.equalsIgnoreCase("Shrava"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

}

