import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArraytoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] name = {"selenium","Java","python","unix","sql"};
		
		//convert array to arraylist
		
		//List<String> nameArrayList = Arrays.asList(name);
				//nameArrayList.contains("selenium");
		ArrayList<String> val = new ArrayList<String>(Arrays.asList(name));
		System.out.println(val);
		System.out.println(val.contains("python"));
		val.add("c++");
		System.out.println(val);
	}

}
