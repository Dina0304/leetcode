package medium;

public class CoinChange {
	//1,2,5
	public static int coinChange(int[] coins, int amount) {
		int[] values = new int[amount+1];//1 ~ amount
		int minNum = 0;
		values[0] = 0;
		if (amount==0) {
			return 0;
		}
		for (int i = 1; i <= amount; i++) {
			minNum = i;
			for (int j = 0; j < coins.length; j++) {
				if(coins[j]<=i) {
					minNum  = Math.min(values[i-coins[j]]+1, minNum);
				}
			}
			values[i] = minNum;
		}
		return minNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {2, 3, 5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}

}
