package wanmei;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
    	int num = cin.nextInt();
    	int[] values = new int[num];
    	int[] weights = new int[num];
    	for (int i = 0; i < num; i++) {
			values[i] = cin.nextInt();
		}
    	for (int i = 0; i < num; i++) {
    		weights[i] = cin.nextInt();
		}
    	int weight = cin.nextInt();
    	
        int result[][] = BackPack(weight, num, weights, values);
        System.out.println(result[num][weight]);

    }

    public static int[][] BackPack(int weight, int num, int[] weights, int[] values) {
        int result[][] = new int[num + 1][weight + 1];
        for (int i = 0; i < num + 1; i++){
        	result[i][0] = 0;
        }
        for (int j = 0; j < weight + 1; j++) {
        	result[0][j] = 0;
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                if (weights[i - 1] <= j) {
                    if (result[i - 1][j] < (result[i - 1][j - weights[i - 1]] + values[i - 1])) {
                    	result[i][j] = result[i - 1][j - weights[i - 1]] + values[i - 1];
                    } else {
                    	result[i][j] = result[i - 1][j];
                    }
                } else {
                	result[i][j] = result[i - 1][j];
                }
            }
        }
        return result;
    }
}
