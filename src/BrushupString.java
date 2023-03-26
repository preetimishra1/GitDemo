
public class BrushupString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ways of String declaration-> 
		//New memory locator operator- Always create objects along with memory location
		
		String s1 =  new String("Welcome");
		String s2 =  new String("Welcome");
		
		//String literal method -  for same values create one variable with single memory allocation
		String s3 =  "Rahul Shetty Academy";
		String s4 =  "Rahul Shetty Academy";
		
		//string split
		 String [] val = s3.split(" ");
		 System.out.println(val[0]);
		 System.out.println(val[1]);
		 System.out.println(val[2]);
		 
		 
		 String [] val1 = s3.split("Shetty");
		 System.out.println(val1[0]);
		 System.out.println(val1[1].trim());
		 for(int i=0;i<s3.charAt(i);i++);
		 {
			 System.out.println(val1);
		 }
		 
		 
		 
		 
		 
	}

}
