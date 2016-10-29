package ValidNumber65;
public class Solution {
    /**
	 * 非空格字符间不能有空格
	 * 第一个非空格字符和最后一个非空格字符之间如果有空格，则false
	 * @param s
	 * @return s." "代表错误；否则代表去掉空格后的字符串。
	 */
	public String isBlankOK(String s) {
		int first = -1; 
		int last = -1;
		int blankCount = 0;
		//获取第一个非空格字符，和最后一个非空格字符
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)!=' ') {
				if (first == -1) {
					first = i;
				}
				last = i;
			}else {
				blankCount++;
			}
		}
		if (blankCount == s.length()) {//全是空格
			s = "";
			return s;
		}
		//判断以上两个字符间是否有空格
		for (int i = first; i <= last; i++) {
			if (s.charAt(i)==' ') {
				s = "";
				return s;
			}
		}
		s = s.trim();
		
		return s;
	}
	
	/** 
	 * @param s
	 * @return ePos: -2:多个e；-1：无e；大于等于0：e的位置
	 */
	public int getEPos(String s) {
		int ePos = -1;
		int eNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='e') {
				ePos = i;
				eNum++;
				if (eNum>1) {
					ePos = -2;
					break;
				}
			}
		}
		
		return ePos;
	}
	
	/**
	 * 判断e是否可以
	 * e前必须有数字
	 * e后必须有内容，对于内容的要求：不能有小数点；若有+，-，必须是+，-&数字
	 * @param s
	 * @param ePos
	 * @return
	 */
	public boolean isEOk(String s, int ePos) {
		boolean isOk = true;
		int count=0;
		if (ePos==0) {
			isOk = false;
		}else {
		    //e前必须有至少一个数字，可以有小数点
			for (int i = 0; i < ePos; i++) {
				if (s.charAt(i)>='0' && s.charAt(i)<='9') {
					count++;
					break;
				}
			}
			if (count==0) {
				isOk = false;
				return isOk;
			}
			
			//e后有至少一位
			if (s.length()-ePos>1) {
				for (int i = ePos; i < s.length(); i++) {//若e后有小数点，则false
					if (s.charAt(i)=='.') {
						isOk = false;
						break;
					}
				}
				if (s.length()-ePos==2) {//e后只有一位，则必须为数字
					if ('0'<=s.charAt(ePos+1) && s.charAt(ePos+1)<='9') {
						isOk = true;
					}else {
						isOk = false;
					}
				}else {//e后有多位,但是不能有小数点
					for (int i = ePos; i < s.length(); i++) {
						if (s.charAt(i)=='.') {
							isOk = false;
							break;
						}
					}
				}
			}else {//e是最后一位
				isOk = false;
			}
		}
		return isOk;
	}
	
	/**
	 * + - 的位置
	 * 只能在首位或者e随后一位
	 * @param s
	 * @return
	 */
	public boolean isPlusMinusOk(String s, int ePos) {
		boolean isOk = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='+' || s.charAt(i)=='-') {
				if (ePos > -1) {//有e
					if (i==0 || i==ePos+1) {
						isOk = true;
					}else {
						return false;
					}
				}else if (ePos == -1) {//无e
					if (i!=0) {
						return false;
					}
				}
				
			}
		}
		return isOk;
	}
	
	/**
	 * 判断小数点位置是否可以
	 * 小数点只能有一个.
	 * @param s
	 * @return
	 */
	public boolean isDotOk(String s) {
		boolean isOk = false;
		int dotCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='.') {
				dotCount++;
				if (dotCount>1) {
					isOk = false;
					break;
				}else {
					isOk = true;
				}
			}else {
				isOk = true;
			}
		}
		
		return isOk;
	}

	public boolean isNumber(String s) {
		boolean isNumber = false;
		int ePos;
		boolean existNumber = false;
		int existNumberCount = 0;
		String trimString = isBlankOK(s);
		if (trimString.equals("")) {
			System.out.println(false);
		}else {
		    if (trimString.length()==1) {
					if ('0'<=trimString.charAt(0) && trimString.charAt(0)<='9') {
						return true;
					}else {
						return false;
					}
				}
			ePos = getEPos(trimString);
			if (ePos == -2) {
				return false;
			}else {
				if (ePos == -1) {//无e
					isNumber = isPlusMinusOk(trimString, ePos) && isDotOk(trimString);
				}else if (ePos >= 0) {//有e，且e的位置为ePos
					isNumber = isEOk(trimString, ePos) && isPlusMinusOk(trimString, ePos) && isDotOk(trimString);
				}
				
				if (isNumber) {
					for (int i = 0; i < trimString.length(); i++) {
						existNumber = '0'<=trimString.charAt(i)&&trimString.charAt(i)<='9';
						if (existNumber) {
							existNumberCount++;
						}
						if (existNumber || trimString.charAt(i)=='e' || trimString.charAt(i)=='.' || trimString.charAt(i)=='+' || trimString.charAt(i)=='-') {
							if (existNumberCount>=1) {
								isNumber = true;
							}else {
								isNumber = false;
							}
						}else {
							isNumber = false;
							break;
						}
					}
				}
			}
		}
		
		return isNumber;
	}
}