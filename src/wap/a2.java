package wap;

import java.util.Scanner;

public class a2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		System.out.println(solve(line));
	}

	public static long solve(String str) {
		final int len = str.length();
		final int[] s = new int[len];
		for (int i = 0; i < len; i++) {
			s[i] = str.charAt(i);
		}
		final int[][] a = new int[len][len];
		for (int i = 0; i < len; i++) {
			a[i][i] = 1;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				final int j2 = i + j;
				int num = 0;
				if (s[j] == s[j2]) {
					num = a[j][j2 - 1] + a[j + 1][j2];
				} else {
					num = a[j][j2 - 1] + a[j + 1][j2] - a[j + 1][j2 - 1];
				}
				if (num >= 1000000007) {
					num = num % 1000000007;
				}
				a[j][j2] = num;
			}
		}
		return a[0][len - 1];
	}

}
