package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		List<String> fbList = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i%3==0 && i%5==0) {
				fbList.add("FizzBuzz");
			}else if (i%3 == 0) {
				fbList.add("Fizz");
			}else if (i%5 == 0) {
				fbList.add("Buzz");
			}else {
				fbList.add(String.valueOf(i));
			}
		}
		
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
