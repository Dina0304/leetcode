import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int exchangeFruits(int[] fruits, int value) {
		int[] change = new int[amount+1];
	    Arrays.fill(change,-1);
	    change[0]=0;
	    
	    for(int i=1;i<=amount;i++){
	        boolean flag = false;
	        int min = Integer.MAX_VALUE;
	        for(int coin:coins){
	            if(i>=coin && change[i-coin] != -1){
	                flag=true;
	                min = Math.min(min,change[i-coin]);
	            }
	        }
	        if(flag){
	            change[i]= 1+min;
	        }
	    }
 
          int[] dp = new int [value+1];
          dp[0]=0;
          for(int i=1;i<=value; i++)
              dp[i]= Integer.MAX_VALUE;

          for(int i=0; i<=value; i++){
              for(int fruit: fruits){
                  if(i+fruit <=value){
                      if(dp[i]==Integer.MAX_VALUE){
                          dp[i+fruit] = dp[i+fruit];
                      }else{
                          dp[i+fruit] = Math.min(dp[i+fruit], dp[i]+1);
                      }
                  }
              }
          }

          if(dp[value] >= Integer.MAX_VALUE)
              return -1;

          return dp[value];
    }

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
    	String arrs = cin.nextLine();
    	int value = cin.nextInt();
    	String[] arr = arrs.split(",");
    	int[] fruits = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
			fruits[i] = Integer.parseInt(arr[i]);
		}
    	int num = exchangeFruits(fruits, value);
    	System.out.println(num);
	}

}
