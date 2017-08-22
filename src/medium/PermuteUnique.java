package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return res;
	}

	public static void helper(List<List<Integer>> res, List<Integer> list,
			int[] nums, boolean[] used) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				used[i] = true;
				list.add(nums[i]);
				helper(res, list, nums, used);
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2 };
		List<List<Integer>> res = permuteUnique(nums);
		System.out.println(res.toString());
	}

}
