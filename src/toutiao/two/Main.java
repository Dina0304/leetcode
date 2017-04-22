package toutiao.two;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<Long> set = new HashSet<Long>();
		while (scanner.hasNext()) {
			Long i = scanner.nextLong();
			if (i == 0) {
				break;
			}
			set.add(i);
		}
		System.out.println(set.size());
	}

}

