package wanmei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
    	String arrs = cin.nextLine();
    	int value = cin.nextInt();
    	String[] arr = arrs.split(",");
    	int[] fruits = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
			fruits[i] = Integer.parseInt(arr[i]);
		}
    	int num = coinNum(fruits, value);
    	System.out.println(num);
	}
	
	public static int coinNum(int[] coinValue,int totalValue){
		List<Integer> coins=new ArrayList<Integer>();
		coins.add(0);
		for(int i=1;i<=totalValue;i++){
			int coin=nearestCoin(i,coinValue);
			int coinNum=coins.get(i-coin)+1;
			coins.add(coinNum);
		}
		return coins.get(totalValue);
	}
	/**
	 * 获取最接近找零钱数的硬币面值
	 */
	private static int nearestCoin(int value,int[] coinValues){
		int res=0;
		int nearest=Integer.MAX_VALUE;
		for(int coinValue:coinValues){
			if(coinValue<=value){
				int distance=value-coinValue;
				if(distance<nearest){
					nearest=distance;
					res=coinValue;
				}
			}
		}
		return res;
	}
}
