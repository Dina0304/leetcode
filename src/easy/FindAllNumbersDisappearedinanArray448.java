package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedinanArray448 {
	/*public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearredNumList = new ArrayList<Integer>();
        Arrays.sort(nums);//比较耗时
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == index) {
				index++;
				continue;
			}
			if (nums[i] < index) {
				continue;
			}
			if(nums[i] > index) {
			    disappearredNumList.add(index);
			    index++;
			    i--;
			} 
			if (index == nums[nums.length-1]) {
				break;
			}
		}
		if(nums.length>0) {
            for (int i = nums[nums.length-1]+1; i <= nums.length; i++) {
    			disappearredNumList.add(i);
    		}
		}
        return disappearredNumList;
    }*/
	/*public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearredNumList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	int val = Math.abs(nums[i])-1;
        	if(nums[val] > 0) {
        		nums[val] = -nums[val];
        	}
		}
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				disappearredNumList.add(i+1);
			}
		}
        return disappearredNumList;
    }*/
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearredNumList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	int val = (nums[i]-1)%nums.length;
        	nums[val] += nums.length;
		}
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= nums.length) {
				disappearredNumList.add(i+1);
			}
		}
        return disappearredNumList;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,5,4,9,9,7,7};
		long startTime=System.nanoTime();   //获取开始时间
		List<Integer> disappearredNumList = findDisappearedNumbers(nums);
		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		for (int i = 0; i < disappearredNumList.size(); i++) {
			System.out.println(disappearredNumList.get(i));
		}
	}

}
