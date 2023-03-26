package testjavacode;

import java.util.stream.Stream;

public class split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s1 =  "Hello World!";


int c = s1.split("\\s").length;
System.out.println(c);
String[] d = s1.split(" ");

for (String a : d)
    System.out.println(a);
	}

}
