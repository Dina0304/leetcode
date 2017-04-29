package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
//	public static int lengthOfLongestSubstring(String s) {
//		int maxLen = 0;
//        for(int i=0; i<s.length()-maxLen; i++) {
//            int[] cArray = new int[128];
//            int count = 0;
//            for(int j=i; j<s.length(); j++) {
//            	int indexValue = cArray[s.charAt(j)];
//                if(indexValue==0) {
//                	cArray[s.charAt(j)]++;
//                    count++;
//                }else {
//                    
//                    break;
//                }
//                maxLen = Math.max(maxLen,count);
//            }
//        }
//        return maxLen;
//    }
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hashmap.containsKey(c)) {
				j = Math.max(j, hashmap.get(c)+1);
				//j=map.get(s.charAt(i))+1;//abba反例
			}
			hashmap.put(c, i);
			maxLen = Math.max(maxLen, i-j+1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(aString));
	}

}
