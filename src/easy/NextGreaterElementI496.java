package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class NextGreaterElementI496 {
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		/*int[] resultNums = new int[findNums.length];
        List<Integer> findNumsList = new ArrayList<Integer>();
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < findNums.length; i++) {
			findNumsList.add(findNums[i]);
		}
        for (int i = 0; i < nums.length; i++) {
			numsList.add(nums[i]);
		}
        for (int i = 0; i < resultNums.length; i++) {
        	int greaterNum = -1;
        	int num = findNumsList.get(i);
			int numIndex = numsList.indexOf(num);
			if(numIndex == nums.length-1) {
			    resultNums[i] = greaterNum;
			    continue;
			}
			for (int j = numIndex+1; j < nums.length; j++) {
				if (num < nums[j]) {
					greaterNum = nums[j];
					break;
				}else {
					greaterNum = -1;
				}
			}
			resultNums[i] = greaterNum;
		}
		return resultNums;*/
		
		
		int[] resultNums = new int[findNums.length];
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (stack.size()!=0 && stack.peek()<nums[i]) {
				numsMap.put(stack.peek(), nums[i]);
				stack.pop();
			}
			stack.push(nums[i]);
		}
		while (stack.size()!=0) {
			numsMap.put(stack.pop(), -1);
		}
		for (int i = 0; i < findNums.length; i++) {
			resultNums[i] = numsMap.get(findNums[i]);
		}
		return resultNums;
    }

	public static void main(String[] args) {
		int[] findNums = {4,1,2};
		int[] nums = {1,3,4,2};
		int[] resultNums = new int[3];
		resultNums = nextGreaterElement(findNums,nums);
		for (int i = 0; i < resultNums.length; i++) {
			System.out.println(resultNums[i]);
		}
	}

}
