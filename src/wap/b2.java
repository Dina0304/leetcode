package wap;

import java.util.ArrayList;
import java.util.Scanner;

public class b2 {
	public static int flag = 0;
	public static ArrayList<Integer> list = new ArrayList<Integer>();

	public static int getSum(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i);
		return sum;
	}

	public static void getSubSet(int[] A, int m, int step) {
		while (step < A.length) {
			list.add(A[step]); // 递归执行语句，向数组链表中添加一个元素
			if (getSum(list) % m == 0) {// 链表中元素和等于m
				flag = 1;
			}

			step++;
			getSubSet(A, m, step);
			list.remove(list.size() - 1); // 回溯执行语句，删除数组链表最后一个元素
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		getSubSet(a, m, 0);
		if (flag == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
