package ValidNumber65;
public class Solution {
    /**
	 * �ǿո��ַ��䲻���пո�
	 * ��һ���ǿո��ַ������һ���ǿո��ַ�֮������пո���false
	 * @param s
	 * @return s." "������󣻷������ȥ���ո����ַ�����
	 */
	public String isBlankOK(String s) {
		int first = -1; 
		int last = -1;
		int blankCount = 0;
		//��ȡ��һ���ǿո��ַ��������һ���ǿո��ַ�
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
		if (blankCount == s.length()) {//ȫ�ǿո�
			s = "";
			return s;
		}
		//�ж����������ַ����Ƿ��пո�
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
	 * @return ePos: -2:���e��-1����e�����ڵ���0��e��λ��
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
	 * �ж�e�Ƿ����
	 * eǰ����������
	 * e����������ݣ��������ݵ�Ҫ�󣺲�����С���㣻����+��-��������+��-&����
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
		    //eǰ����������һ�����֣�������С����
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
			
			//e��������һλ
			if (s.length()-ePos>1) {
				for (int i = ePos; i < s.length(); i++) {//��e����С���㣬��false
					if (s.charAt(i)=='.') {
						isOk = false;
						break;
					}
				}
				if (s.length()-ePos==2) {//e��ֻ��һλ�������Ϊ����
					if ('0'<=s.charAt(ePos+1) && s.charAt(ePos+1)<='9') {
						isOk = true;
					}else {
						isOk = false;
					}
				}else {//e���ж�λ,���ǲ�����С����
					for (int i = ePos; i < s.length(); i++) {
						if (s.charAt(i)=='.') {
							isOk = false;
							break;
						}
					}
				}
			}else {//e�����һλ
				isOk = false;
			}
		}
		return isOk;
	}
	
	/**
	 * + - ��λ��
	 * ֻ������λ����e���һλ
	 * @param s
	 * @return
	 */
	public boolean isPlusMinusOk(String s, int ePos) {
		boolean isOk = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='+' || s.charAt(i)=='-') {
				if (ePos > -1) {//��e
					if (i==0 || i==ePos+1) {
						isOk = true;
					}else {
						return false;
					}
				}else if (ePos == -1) {//��e
					if (i!=0) {
						return false;
					}
				}
				
			}
		}
		return isOk;
	}
	
	/**
	 * �ж�С����λ���Ƿ����
	 * С����ֻ����һ��.
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
				if (ePos == -1) {//��e
					isNumber = isPlusMinusOk(trimString, ePos) && isDotOk(trimString);
				}else if (ePos >= 0) {//��e����e��λ��ΪePos
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