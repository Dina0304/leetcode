package easy;

import java.util.Arrays;

public class SingleNumber136 {
	public static int singleNumber(int[] nums) {
        int singleNumber = 0;
        int len = nums.length;
        if (len == 1) {
			return nums[0];
		}
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
        	if (i+1 == len) {
				singleNumber = nums[len-1];
				break;
			}
			if (nums[i] == nums[i+1]) {
				i++;
			}else {
				singleNumber = nums[i];
				break;
			}
		}
        return singleNumber;
    }

	public static void main(String[] args) {
		int[] nums = {0,1,0};
		int singleNum = singleNumber(nums);
		System.out.println(singleNum);
	}

}
