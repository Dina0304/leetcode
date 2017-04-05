package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
        for(int i=0; i<s.length()-maxLen; i++) {
            int[] cArray = new int[128];
            int count = 0;
            for(int j=i; j<s.length(); j++) {
            	int indexValue = cArray[s.charAt(j)];
                if(indexValue==0) {
                	cArray[s.charAt(j)]++;
                    count++;
                }else {
                    
                    break;
                }
                maxLen = Math.max(maxLen,count);
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(aString));
		Map<Character,List<Integer>> map = new HashMap<Character, List<Integer>>();
		Set<Character> set = map.keySet();
		set.contains("");
		List<Integer> list = new ArrayList<Integer>();
		list.clear();
		map.values();
	}

}
