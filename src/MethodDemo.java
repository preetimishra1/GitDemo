
public class MethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
  MethodDemo demo = new MethodDemo();
  String name = demo.getdata();
  System.out.println(name);
  
  MethodDemo2 val = new MethodDemo2();
  String name2 = val.getuserdata();
  System.out.println(name2);
  System.out.println(getdata2());
  
  
	}
	public String getdata() {
		//System.out.println("hELLO");
		return "rahul shetty";
	}
	
	public static String getdata2() {
		//System.out.println("hELLO");
		return "Welcome2";
	}

}

