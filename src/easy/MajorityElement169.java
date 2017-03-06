package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,2,3,2};
		int maj = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(count==0) {
                count++;
                maj = nums[i];
            }else if(maj == nums[i]) {
                count++;
            }else{
                count--;
            }
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        System.out.println(maj);
        System.out.println(0>>1);
	}

}
