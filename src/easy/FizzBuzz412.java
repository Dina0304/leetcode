package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		List<String> fbList = new ArrayList<String>();
		int three = n/3;
		int five = n/5;
		int fifteen = n/15;
		for (int i = 0; i < n; i++) {
			fbList.add(i, i+"");
		}
		for (int i = 0; i < three; i++) {
			fbList.set(i, "Fizz");
		}
		for (int i = 0; i < five; i++) {
			fbList.set(i, "Buzz");
		}
		for (int i = 0; i < fifteen; i++) {
			fbList.set(i, "FizzBuzz");
		}
		fbList.set(index, element)
		
//        List<String> fbList = new ArrayList<String>();
//        for (int i = 1; i <= n; i++) {
//        	int flag = 0;
//			if (i%3 == 0) {
//				flag += 1;
//			}
//			if (i%5 == 0) {
//				flag += 2;
//			}
//			switch (flag) {
//			case 0:
//				fbList.add(i+"");
//				break;
//			case 1:
//				fbList.add("Fizz");
//				break;
//			case 2:
//				fbList.add("Buzz");
//				break;
//			case 3:
//				fbList.add("FizzBuzz");
//				break;
//			}
//		}
		return fbList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
