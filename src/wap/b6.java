package wap;

import java.util.Scanner;

public class b6 {
	public static boolean fillBag(int[] weight, int M) {
		final int N = weight.length;
		final int[] f = new int[M + 1];
		for (int i = 0; i < N; i++) {
			final int w = weight[i];
			for (int j = M; j >= w; j--) {
				f[j] = Math.max(f[j], f[j - w] + w);
				if (f[j] == M) {
					return true;
				}
			}
		}
		return f[M] == M;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] a = new int[n];
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			if (num >= m && (num % m) == 0) {
				flag = true;
				break;
			}
			a[i] = num % m;
		}
		if (flag || fillBag(a, m))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
