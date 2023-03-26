package testjavacode;

import java.util.Scanner;

public class FahrenheitToCelsius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Temperature in Farenheit");
		int temperatue = sc.nextInt();
		
		temperatue = ((temperatue - 32)*5)/9;
		System.out.println("Temperatue in Celsius = " + temperatue);
		
		
	}

}
