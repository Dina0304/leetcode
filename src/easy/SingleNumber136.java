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
		/*int[] nums = {0,1,0};
		int singleNum = singleNumber(nums);
		System.out.println(singleNum);*/
		String s = "dddccdbba";
		int index = -1;
        String temp = "";
        System.out.println("temp: "+temp.concat("a"));
        if(s.length()==1) {
            System.out.println(0);
        }
        for(int i=0; i<s.length(); i++) {
        	String curString = String.valueOf(s.charAt(i));
            if(temp.lastIndexOf(curString)==-1) {
                if(i == s.lastIndexOf(curString)) {
                    index = i;
                    break;
                }else if(i != s.lastIndexOf(curString)){
                    temp = temp.concat(curString);
                }
            }
        }
        System.out.println(index);
	}

}
