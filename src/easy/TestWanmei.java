package easy;

import java.util.Scanner;

public class TestWanmei {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int flag = 2;
		int i=0;
		String[] s = new String[flag];
		cin.nextInt();
 		while (i<flag) {
			
			String c = cin.nextLine();
			s[i] = c+"";
			i++;
		}
 		for (int j = 0; j < s.length; j++) {
			System.out.println(s[j]);
		}
	}

}
