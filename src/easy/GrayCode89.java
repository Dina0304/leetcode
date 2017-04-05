package easy;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
	public List<Integer> grayCode(int n) {
        List<Integer> grayCode = new ArrayList<Integer>();
        for(int i=0; i<(1<<n); i++) {
            grayCode.add(i^(i>>1));
        }
        return grayCode;
    }
	
	public static String[] strGrayCode(int n) {
		String[] grayCode = new String[1<<n];
		if(n == 1) {
			grayCode[0] = "0";
			grayCode[1] = "1";
			return grayCode;
		}
		String[] last = strGrayCode(n-1); 
		for (int i = 0; i < (1<<(n-1)); i++) {
			grayCode[i] = "0" + last[i];
			grayCode[(1<<n)-i-1] = "1" + last[i];
		}
		return grayCode;
		
	}

	public static void main(String[] args) {
		String[] grayCodeStrings = new String[8];
		grayCodeStrings = strGrayCode(3);
		for (int i = 0; i < grayCodeStrings.length; i++) {
			System.out.println(grayCodeStrings[i]);
		}

	}

}
