import java.util.ArrayList;

public class corejavaforloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr2 = {1,2,3,4,5,8,9,78,89};
		 for (int i=0;i<arr2.length;i++) {
			if(arr2[i]%2 == 0) 
			{
				System.out.println(arr2[i]);
				break;
			}
			else {
				System.out.println(arr2[i]+" : not multiple of 2");
			}
		 }
		 ArrayList<String> al= new ArrayList<String>();
		 al.add("Preeti");
		 al.add("shivam");
		 al.add("shreya");
		 al.add("rituja");
		 ///a.remove(2);
		 System.out.println(al.get(3));
		 System.out.println("****************");
		 for (String val : al)
		 {
			 System.out.println(val);
		 }
		 System.out.println("****************");
		 System.out.println(al.contains("rituja"));
	}

}
