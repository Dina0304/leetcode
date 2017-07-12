package easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
	
	public static List<String> getResult(String s) {
		List<String> result = new ArrayList<String>();
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i)=='+' && s.charAt(i-1)=='+') {
				result.add(s.substring(0,i-1)+"--"+s.substring(i+1));
			}
		}
		for(String str:result) {
			System.out.println(str);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getResult("++++");
		String aString = " ";
	}

}
