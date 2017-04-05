package hihocode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FontSize {
	public static int fontSize(int n, int p, int w, int h, List<Integer> a) {
		if(n==0 || p==0 || w==0 || h==0) {
		    return 0;
		}
		int fontSize = 0;
		int maxFS = Math.min(w, h);
		int rowNum = 0;
		for (int s = maxFS; s > 0; s--) {
			for (int j = 0; j < a.size(); j++) {
				int yushu = a.get(j)%(w/s);
				rowNum += yushu==0?a.get(j)/(w/s):(a.get(j)/(w/s))+1;
				
			}
			if (rowNum <= (h/s)*p) {
				fontSize = s;
				return fontSize;
			}
			rowNum = 0;
		}
		
		return fontSize;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int testNum = cin.nextInt();
		int[] N = new int[testNum];
		int[] P = new int[testNum];
		int[] W = new int[testNum];
		int[] H = new int[testNum];
		Map<Integer, List<Integer>> A = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < testNum; i++) {
			N[i] = cin.nextInt();
			P[i] = cin.nextInt();
			W[i] = cin.nextInt();
			H[i] = cin.nextInt();
			List<Integer> listA = new ArrayList<Integer>();
			for (int j = 0; j < N[i]; j++) {
				listA.add(cin.nextInt());
			}
			A.put(i, listA);
		}
		for (int i = 0; i < testNum; i++) {
			System.out.println(fontSize(N[i], P[i], W[i], H[i], A.get(i)));
		}
	}

}
