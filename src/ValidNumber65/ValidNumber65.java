package validNumber65;
import java.io.LineNumberReader;
import java.util.ArrayList;

import javax.sound.sampled.Line;


public class ValidNumber65 {
	
	//首位只能使0-9，+，-，e
	public static boolean isFirstOk(String s) {
		boolean isOk = false;
		char firstChar = s.charAt(0);
		if (('0'<=firstChar && firstChar<='9') || (firstChar=='e') || (firstChar==' ') || (firstChar=='.') || (firstChar=='+') || (firstChar=='-')) {
			isOk = true;
		}
		return isOk;
	}
	//最后一位只能是数字0-9，不能是e，不能是+-
	public static boolean isLastOk(String s) {
		boolean isOk = false;
		char lastChar = s.charAt(s.length()-1);
		if('0'<=lastChar && lastChar<='9' || (lastChar==' ') || (lastChar=='.')) {
			isOk = true;
		} 
		return isOk;
	}
	
	//e前 或者 无e的中间
	public static boolean isBeforeEOk(String s,int pos,boolean e) {
		boolean isOk = false;
		if (e) {//有e
			if (pos==0) {
				return false;
			}
			if (pos == 1) {
				return true;
			}
			for (int i = 1; i < pos; i++) {
				if (('0'<=s.charAt(i) && s.charAt(i)<='9') || (s.charAt(i)=='.')) {
					isOk = true;
				}else {
					isOk = false;
					return isOk;
				}
			}
		}else {
			if(s.length()>2) {
				for (int i = 1; i < s.length()-1; i++) {
					if (('0'<=s.charAt(i) && s.charAt(i)<='9') || (s.charAt(i)=='.') || (s.charAt(i)==' ')) {
						isOk = true;
					}else {
						isOk = false;
						return isOk;
					}
				}
			}else {
				isOk = true;
			}
			
		}
		
		return isOk;
	}
	
	//e后1
	public static boolean isE1Ok(String s, int pos) {
		boolean isOk = false;
		if (pos<s.length()-1) {
			if (('0'<s.charAt(pos+1)) && (s.charAt(pos+1)<='9')) {
				isOk = true;
			}
		}else {//e后无
			isOk = false;
		}
		return isOk;
	}
	
	//e后2后
	public static boolean isE2LaterOk(String s,int pos) {
		boolean isOk = false;
		if (pos+2>s.length()-1) {//无e后2后
			isOk = true;
		}else {
			for (int i = pos+1; i < s.length(); i++) {
				if (('0'<=s.charAt(i)) && (s.charAt(i)<='9')) {
					isOk = true;
				}else {
					isOk = false;
					return isOk;
				}
			}
		}
		
		return isOk;
	}
	
	//返回e的位置。-2：多个e，报错；-1：无e 
	public static int ePos(String s) {
		int ePos = -1;
		int eCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='e') {
				ePos = i;
				eCount++;
			}
		}
		if (eCount>1) {
			ePos = -2;//wrong
		}
		
		return ePos;
	}
	public static boolean isOtherOk(String s) {
		boolean isOk = false;
		for (int i = 1; i < s.length()-1; i++) {
			if (('0'<=s.charAt(i) && s.charAt(i)<='9') || (s.charAt(i)=='e') || (s.charAt(i)=='.')) {
				isOk = true;
			}else {
				isOk = false;
			}
		}
		return isOk;
	}

	public static boolean isNumber(String s) {
		boolean isNumber = false;
		int count = 0;
		int dotCount = 0,numCount=0;
		int flag1 = -1,flag2= -1,flag3 = -1;
		//只有一位
		if (s.length()==1) {
			if ('0'<=s.charAt(0) && s.charAt(0)<='9') {
				return true;
			}else {
				return false;
			}
		}
		//不能全是空格
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==' ') {
				count++;
			}
		}
		if(count == s.length()) {
			return false;
		}
		
		//数字之间不能有空格
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)!=' ') {
				flag1 = i;//第一个非空格的位置
				break;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)!=' ') {
				flag2 = i;//最后一个非空格的位置
			}
		}
		for (int i = flag1; i <= flag2; i++) {
			if (s.charAt(i)==' ') {
				return false;
			}
		}
		
		//小数点只能有1个，并且除了空格外不能只有小数点
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='.') {
				dotCount++;
			}
			if (s.charAt(i)=='e' || '0'<=s.charAt(i)&&s.charAt(i)<='9' || s.charAt(i)=='.') {
				numCount++;
			}
		}
		if ((dotCount==numCount) || dotCount>1) {
			return false;
		}
		
		int ePos = ePos(s);
		if (ePos == -2) {//多个e
			return false;
		} else if (ePos == -1) {//无e
			if (isFirstOk(s) && isLastOk(s) && isBeforeEOk(s, ePos, false)) {
				isNumber = true;
			}
		} else {//有e
			for(int i=0; i<ePos;i++) {
			    if(s.charAt(i)<'0' || s.charAt(i)>'9') {
			        isNumber = false;
			    }else if('0'<=s.charAt(i) && s.charAt(i)<='9'){
			        isNumber = true;
			        break;
			    }
			}
			if(!isNumber) {
			    return false;
			}
			if(ePos==1 && s.charAt(ePos-1) == '.') {
				return false;
			}
			if (isFirstOk(s) && isLastOk(s) && isE1Ok(s, ePos) && isE2LaterOk(s, ePos) && isBeforeEOk(s, ePos, true)) {
				isNumber = true;
			}else {
				isNumber = false;
			}
		}
		return isNumber;
        
    }
	public static void main(String[] args) {
		String s = " 5e3.";
		
		
		System.out.println(isNumber(s));

	}

}
