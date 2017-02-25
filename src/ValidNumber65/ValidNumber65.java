package ValidNumber65;
import java.io.LineNumberReader;
import java.util.ArrayList;

import javax.sound.sampled.Line;


public class ValidNumber65 {
	
	//��λֻ��ʹ0-9��+��-��e
	public static boolean isFirstOk(String s) {
		boolean isOk = false;
		char firstChar = s.charAt(0);
		if (('0'<=firstChar && firstChar<='9') || (firstChar=='e') || (firstChar==' ') || (firstChar=='.') || (firstChar=='+') || (firstChar=='-')) {
			isOk = true;
		}
		return isOk;
	}
	//���һλֻ��������0-9��������e��������+-
	public static boolean isLastOk(String s) {
		boolean isOk = false;
		char lastChar = s.charAt(s.length()-1);
		if('0'<=lastChar && lastChar<='9' || (lastChar==' ') || (lastChar=='.')) {
			isOk = true;
		} 
		return isOk;
	}
	
	//eǰ ���� ��e���м�
	public static boolean isBeforeEOk(String s,int pos,boolean e) {
		boolean isOk = false;
		if (e) {//��e
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
	
	//e��1
	public static boolean isE1Ok(String s, int pos) {
		boolean isOk = false;
		if (pos<s.length()-1) {
			if (('0'<s.charAt(pos+1)) && (s.charAt(pos+1)<='9')) {
				isOk = true;
			}
		}else {//e����
			isOk = false;
		}
		return isOk;
	}
	
	//e��2��
	public static boolean isE2LaterOk(String s,int pos) {
		boolean isOk = false;
		if (pos+2>s.length()-1) {//��e��2��
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
	
	//����e��λ�á�-2�����e������-1����e 
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
		//ֻ��һλ
		if (s.length()==1) {
			if ('0'<=s.charAt(0) && s.charAt(0)<='9') {
				return true;
			}else {
				return false;
			}
		}
		//����ȫ�ǿո�
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==' ') {
				count++;
			}
		}
		if(count == s.length()) {
			return false;
		}
		
		//����֮�䲻���пո�
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)!=' ') {
				flag1 = i;//��һ���ǿո��λ��
				break;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)!=' ') {
				flag2 = i;//���һ���ǿո��λ��
			}
		}
		for (int i = flag1; i <= flag2; i++) {
			if (s.charAt(i)==' ') {
				return false;
			}
		}
		
		//С����ֻ����1�������ҳ��˿ո��ⲻ��ֻ��С����
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
		if (ePos == -2) {//���e
			return false;
		} else if (ePos == -1) {//��e
			if (isFirstOk(s) && isLastOk(s) && isBeforeEOk(s, ePos, false)) {
				isNumber = true;
			}
		} else {//��e
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
