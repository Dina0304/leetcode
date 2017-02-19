package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextGreaterElementI496 {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] resultNums = new int[findNums.length];
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
		return resultNums;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
