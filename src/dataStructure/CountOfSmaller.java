package dataStructure;

/**
 * Created by dina on 17/10/16.
 */
public class CountOfSmaller {
    public static int[] countOfSmaller(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }

        int[] answer = new int[n];
        helper(nums, 0, n-1, pos, answer);

        return answer;
    }

    public static void helper(int[] nums, int from, int to, int[] pos, int[] answer) {
        if(from >= to) {
            return;
        }
        int mid = (from + to) >> 1;

        helper(nums, from, mid, pos, answer);
        helper(nums, mid+1, to, pos, answer);

        int[] temp = new int[to-from+1];

        for (int i = 0, x=from, y=mid+1; i < temp.length; i++) {
            if (x > mid) {
                temp[i] = pos[y++];
            } else if (y > to) {
                temp[i] = pos[x++];
            } else if (nums[pos[x]] > nums[pos[y]]) {
                answer[pos[x]] += to - y + 1;
                temp[i] = pos[x++];
            } else {
                temp[i] = pos[y++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            pos[i+from] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        int[] answer = countOfSmaller(nums);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
