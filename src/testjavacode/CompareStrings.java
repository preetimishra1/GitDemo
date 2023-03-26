package testjavacode;

import java.util.Scanner;

public class CompareStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first string");

		String s1 = sc.next();
		System.out.println("Enter the second string");

		String s2 = sc.next();
		
		if ( s1.compareTo(s2) > 0 )
			System.out.println("First string is greater than second.");
			else if ( s1.compareTo(s2) < 0 )
			System.out.println("First string is smaller than second.");
			else
			System.out.println("Both strings are equal.");

	}

}
