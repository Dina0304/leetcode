package wap;

import java.util.Scanner;

public class a1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		System.out.println(solve(line));
	}

	public static long solve(String s) {
		int len = s.length();
		int[][] a = new int[len][len];
		for (int i = 0; i < len; i++) {
			a[i][i] = 1;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (s.charAt(j) == s.charAt(i + j)) {
					a[j][i + j] = a[j][i + j - 1] + a[j + 1][i + j];
				} else {
					a[j][i + j] = a[j][i + j - 1] + a[j + 1][i + j] - a[j + 1][i + j - 1];
				}
				if (a[j][i + j] > 1000000007) {
					a[j][i + j] = a[j][i + j] % 1000000007;
				}
			}
		}
		return a[0][len - 1];
	}

}
