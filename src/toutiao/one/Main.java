package toutiao.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		int m, n;
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		int[] arrayM = new int[m];
		for (int i = 0; i < m; i++) {
			arrayM[i] = scanner.nextInt();
		}
		n = scanner.nextInt();
		int[] arrayN = new int[n];
		for (int i = 0; i < n; i++) {
			arrayN[i] = scanner.nextInt();
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			set.add(arrayM[i]);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (set.contains(arrayN[i]) == true) {
				list.add(arrayN[i]);
			}
		}

		// output
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i < list.size() - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}

	}
}