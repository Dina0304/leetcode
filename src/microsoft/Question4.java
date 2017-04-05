package microsoft;

import java.util.Scanner;

public class Question4 {
	public static long Catalan(int n) {
		if (n <= 1) {
			return 1;
		}
		long[] h = new long[n + 1];
		h[0] = 1;
		h[1] = 1;
		int i=2;
		while (i<=n) {
			h[i] = 0;
			for (int j = 0; j < i; j++) {
				h[i] += (h[j] * h[i-1-j]) % 1000000007;
			}
			i++;
		}
		/*for (int i = 2; i <= n; i++) {
			h[i] = 0;
			for (int j = 0; j < i; j++) {
				h[i] += (h[j] * h[i-1-j]) % 1000000007;
			}
		}*/
		long ans = h[n];
		return ans;
	}

	public static void main(String[] args) {
		int left = 0, right = 0;
		Scanner cin = new Scanner(System.in);
		String s = cin.nextLine();
		int brackets = 0;
		long ans = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				if (i > 0 && s.charAt(i - 1) == ')') {
					brackets += Math.abs(left - right);
					ans *= Catalan(Math.max(left, right)) % 1000000007;
					left = 0;
					right = 0;
				}
				left++;
			} else {
				right++;
			}
		}

		brackets += Math.abs(left - right);
		ans *= Catalan(Math.max(left, right)) % 1000000007;
		left = 0;
		right = 0;
		System.out.println(brackets + " " + ans);

	}
}
