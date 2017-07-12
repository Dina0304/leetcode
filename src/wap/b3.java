package wap;

import java.util.Scanner;

public class b3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt() % m;
		}

		Package[] pg = new Package[n];
		for (int i = 0; i < n; i++) {
			pg[i] = new Package(1, arr[i]);
		}

		int[][] bestValues = new int[pg.length + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					bestValues[i][j] = 0;// 临界情况
				} else {
					if (j < pg[i - 1].getWeight()) {
						bestValues[i][j] = bestValues[i - 1][j];// 当第n件物品重量大于包的重量时，最佳值取前n-1件的
					} else {
						int iweight = pg[i - 1].getWeight(); // 当第n件物品重量小于包的重量时，分两种情况，分别是装第n件或不装，比较取最大
						int ivalue = pg[i - 1].getValue();
						bestValues[i][j] = Math.max(bestValues[i - 1][j], ivalue + bestValues[i - 1][j - iweight]);
					}
				}
			}
		}
		if (bestValues[n][m] != 0) {
			System.out.println("Yes");
		}else{
			System.out.print("No");
		}
	}
}

class Package {

	int value;
	int weight;

	Package(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

}
