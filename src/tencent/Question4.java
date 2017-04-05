package tencent;

import java.util.Scanner;

public class Question4 {
	// /**腾讯编程题4：格式化输出
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		int arrLen = str.length() / 16;
		String[] strArr = new String[arrLen];

		for (int i = 0; i < arrLen; i++) {
			strArr[i] = str.substring(16 * i, 16 * (i + 1));
			System.out.printf("%08x  ", i * 16);
			for (int j = 0; j < strArr[i].length(); j++) {
				String c = strArr[i].charAt(j) + "";
				int ic = c.charAt(0);
				System.out.print(Integer.toHexString(ic) + " ");
				// System.out.printf("%x ",ic);
				if (j == 7) {
					System.out.print(" ");
				}
			}
			System.out.println(" " + strArr[i]);
		}

	}
	// abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl
}
