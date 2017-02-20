package easy;

import java.util.Arrays;

public class ReverseString344 {
	public static String reverseString(String s) {
		char[] cs = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char a = cs[i];
			cs[i] = cs[j];
			cs[j] = a;
			i++;
			j--;
        }
		
        return new String(cs);
//		String teString = "";
//        for (int i = s.length()-1; i >= 0; i--) {
//        	cs[s.length()-1-i] = s.charAt(i);
//		}
//        return new String(cs);
    }
	public static void main(String[] args) {
		String s = "he";
		System.out.println(s.length());
		String result = reverseString(s);
		System.out.println(result);
	}

}
