package easy;

import java.util.ArrayList;
import java.util.List;

public class HarmmingDistance461 {
	public static int hammingDistance(int x, int y) {
		List<Integer> XbitNum = bitNum(x);
		List<Integer> YbitNum = bitNum(y);
		int len = XbitNum.size()>=YbitNum.size()?YbitNum.size():XbitNum.size();
		int minus = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (XbitNum.get(i) != YbitNum.get(i)) {
				count++;
			}
		}
		if (XbitNum.size()>len) {
			for (int i = len; i < XbitNum.size(); i++) {
				if (XbitNum.get(i)!=0) {
					minus++;
				}
			}
		}
		if (YbitNum.size()>len) {
			for (int i = len; i < YbitNum.size(); i++) {
				if (YbitNum.get(i)!=0) {
					minus++;
				}
			}
		}
		return minus+count;
    }

	public static List<Integer> bitNum(int x) {
		List<Integer> bitNum = new ArrayList<Integer>();
		while(true) {
			int temp = x/2;
			bitNum.add(x%2);
			x = temp;
			if (x == 0) {
				break;
			}
		}
		return bitNum;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1,4));
		int a = 22;
		System.out.println("a 非的结果是："+(~a));
	}

}
