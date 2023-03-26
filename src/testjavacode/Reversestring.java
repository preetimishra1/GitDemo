package testjavacode;

public class Reversestring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String orgstring= "Hello World";
		String revstring = "";
		
		for(int i=0;i<orgstring.length();i++)
		{
			revstring=orgstring.charAt(i)+revstring;
		}
System.out.println("Reversed String is"+revstring);
	}

}
