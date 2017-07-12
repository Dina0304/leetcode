package offer;

import java.util.Iterator;

public class ReplaceSpaces {
	public static void replaceSpaces(char[] str, int length,int realLength) {
		int spaceCount = 0, newLength;
		for(int i=0; i<length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		System.out.println("realLength="+realLength);
		newLength = realLength+spaceCount*2;
		for(int i=realLength-1; i>=0; i--) {
			if (str[i]==' ') {
				str[newLength-3] = '%';
				str[newLength-2] = '2';
				str[newLength-1] = '0';
				newLength = newLength-3;
			}else{
				str[newLength-1] = str[i];
				newLength--;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] str = new char[7];
		String string = "He is";
		int length = str.length;
		int realLength = string.length();
		for(int i=0; i<string.length();i++) {
			str[i] = string.charAt(i);
		}
		System.out.println("length="+length);
		replaceSpaces(str, length,realLength);
		for (char c : str) {
			System.out.print(c);
		}
	}

}
