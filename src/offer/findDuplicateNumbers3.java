package offer;

import java.util.ArrayList;
import java.util.List;

public class findDuplicateNumbers3 {
	public static List<Integer> findDuplicatedNumbers(int[] nums) {
		List<Integer> dupNums = null;
		if (nums==null || nums.length==0) {
			dupNums = new ArrayList<Integer>();
			dupNums.add(-1);
			return dupNums;
		}
		int n = nums.length;
		dupNums = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>=n) {
				dupNums.add(-1);
				return dupNums;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]!=i) {
				if (nums[i] == nums[nums[i]]) {
					dupNums.add(nums[i]);
					break;
				}
				swap(nums, i, nums[i]);
			}
		}
		
		
		return dupNums;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3};
		List<Integer> list = findDuplicatedNumbers(nums);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}

}
