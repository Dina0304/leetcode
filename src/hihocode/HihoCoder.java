package hihocode;

import java.util.Scanner;

public class HihoCoder {
	public static int getIndex(int num, int[] hihoCode) {
		int index = hihoCode.length-1;
		for(int i=hihoCode.length-1; i>=0; i--) {
			if (i>0 && hihoCode[i]>hihoCode[i-1]) {
				index = i-1;
			}else {
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int num = cin.nextInt();
		if (num<=0) {
			return;
		}
		int[] hihoCode = new int[num];
		for (int i = 0; i < num; i++) {
			hihoCode[i] = cin.nextInt();
		}
		int index = getIndex(num, hihoCode);
		if (index == 0) {
			System.out.print(hihoCode[0]);
		}
		for (int i = 0; i < index; i++) {
			System.out.print(hihoCode[i]);
			if (i<index-1) {
				System.out.print(' ');
			}
		}
	}
}
