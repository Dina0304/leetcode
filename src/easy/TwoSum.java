package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
            
        }
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,2,4};
		int target = 6;
		int[] result = twoSum(numbers, target);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
