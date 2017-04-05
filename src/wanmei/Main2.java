package wanmei;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Main2 {
	public static int exchangeFruits(int[] fruits, int value) {
		
        int[] dp = new int[value + 1];
        for (int i = 1; i <= value; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 0; j < fruits.length; j++)
                if (i >= fruits[j] && dp[i - fruits[j]] != 0x7fffffff)
                    dp[i] = Math.min(dp[i], dp[i - fruits[j]] + 1);
        }
        return dp[value] == 0x7fffffff ? -1 : dp[value];
    }

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
    	String arrs = cin.nextLine();
    	int value = cin.nextInt();
    	String[] arr = arrs.split(",");
    	int[] fruits = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
			fruits[i] = Integer.parseInt(arr[i]);
		}
    	int num = exchangeFruits(fruits, value);
    	System.out.println(num);
	}
}
