package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	/**
	 * 找到所有长度至少为2的递增序列
	 * @param
	 * @return
	 */
	public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

   public static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
       if (holder.size() >= 2) {
    	   System.out.println(new ArrayList(holder).toString());
           res.add(new ArrayList(holder));
       }
       for (int i = index; i < nums.length; i++) {
    	   if (holder.size()>=1) {
    		   int nexthold = holder.get(holder.size() - 1);
    	   }
    	   int numsi = nums[i];
    	   
           if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
               holder.add(nums[i]);
               findSequence(res, holder, i + 1, nums);
               holder.remove(holder.size() - 1);
           }
       }
   }
   
   /**
    * 
    * @param strs
    * @return
    */
	public static int findLUSlength(String[] strs) {
	    Map<String, Integer> subseqFreq = new HashMap<String, Integer>();
	    for (String s : strs) 
	        for (String subSeq : getSubseqs(s))
	            subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
	    int longest = -1;
	    for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
	        if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
	    return longest;
	}

	public static Set<String> getSubseqs(String s) {
	    Set<String> res = new HashSet<String>();
	    if (s.length() == 0) {
	         res.add("");
	         return res;
	    }
	    Set<String> subRes = getSubseqs(s.substring(1));
	    res.addAll(subRes);
	    for (String seq : subRes) res.add(s.charAt(0) + seq);
	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,9,6,7,8};
		List<List<Integer>> list = findSubsequences(arr);
		
//		String[] strs = {"aabbcc", "aabbcc","cb"};
//		System.out.println(findLUSlength(strs));
//		String s="abccccd";
//		int start = s.indexOf("cccc");
//		System.out.println(start);
//		int len = (int)Math.ceil(5.1);
//		System.out.println(len);
	}

}
