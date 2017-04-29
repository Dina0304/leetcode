package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 用分治的思想
 * 如果字符串长度小于k，返回0
 * 
 * 每次首先统计字符串中各个字符出现的频次，存放在长度为26的int数组中
 * 2层循环：外层遍历这26个字母，内层遍历从start到end范围的字符串
 * 对于出现次数大于0且小于k的，作为分割点，将原有字符串分成两部分，对这两部分分别统计最大长度，并返回
 * 
 * 如果从start到end范围的字符串中每个字符出现次数都大于等于k，则返回end-start
 * @author dina
 *
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public static int longestSubstring(String s, int k) {
		char[] str = s.toCharArray();
		return helper(str,0,str.length,k);
	}
	public static int helper(char[] str, int start, int end, int k) {
		if(end-start<k) return 0;
		int[] count = new int[26];
		for (int i = start; i < end; i++) {
			count[str[i]-'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i]<k && count[i]>0) {
				for(int j=start; j<end; j++) {
					if (str[j]==i+'a') {
						int left = helper(str, start, j, k);
						int right = helper(str, j+1, end, k);
						return Math.max(left, right);
					}
				}
			}
		}
		return end-start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababbc";
		int k=3;
		System.out.println(longestSubstring(s, k));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String string : args) {
			
		}
	}

}
