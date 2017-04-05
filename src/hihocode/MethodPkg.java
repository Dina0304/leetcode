package hihocode;

import java.util.Scanner;


public class MethodPkg {
	/**
	 * 获取输入
	 */
	public static void getInput() {
		Scanner cin = new Scanner(System.in);
		int num = cin.nextInt();
		int[] intArr = new int[num];
		String[] strArr = new String[num];
		for (int i = 0; i < num; i++) {
			intArr[i] = cin.nextInt();
			strArr[i] = cin.nextLine();
		}
	}
	
	/**
	 * 返回int类型数字对于的二进制形式的字符串，可指定位数
	 * @param digit
	 * @return
	 */
	public static String getEightBit(int digit) {
		String zeroStr = "";
		int bitNum = 8;
		String bitStr = Integer.toBinaryString(digit);
		for (int i = 0; i < bitNum-bitStr.length(); i++) {
			zeroStr = zeroStr.concat("0");
		}
		bitStr = zeroStr.concat(bitStr);
		
		return bitStr;
	}
	/**
	 * 类型转换
	 * @param str
	 * @return
	 */
	public static int strToInt(String str) {
		//string 转 int
		int value = Integer.parseInt(str);
		
		//string 转 double
		double dblValue = Double.parseDouble(str);

		//int 转 double
		double dbl = (double)value;
		return value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digit = 5;
		System.out.println(strToInt(getEightBit(digit)));
	}

}
