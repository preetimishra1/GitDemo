package testjavacode;

import java.util.Scanner;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =  new Scanner(System.in);
		 int x = sc.nextInt();
		 int y = sc.nextInt();
		 int z = sc.nextInt();
		 
		 if ( x > y && x > z )
			 System.out.println("First number is largest.");
			 else if ( y > x && y > z )
			 System.out.println("Second number is largest.");
			 else if ( z > x && z > y )
			 System.out.println("Third number is largest.");
			 else
			 System.out.println("Entered numbers are not distinct.");
	}

}
