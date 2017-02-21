package easy;

public class DetectCapital520 {
	public boolean detectCapitalUse(String word) {
        boolean isCapital = false;
        int lowerCount = 0;
        int upperCount = 0;
        if (word.length()==1) {
			isCapital = true;
		}else {
			for (int i = 0; i < word.length(); i++) {
				if ('a'<=word.charAt(i) && word.charAt(i)<='z') {
					lowerCount++;
				}
				if ('A'<=word.charAt(i) && word.charAt(i)<='Z') {
					upperCount++;
				}
			}
		}
        boolean isFirUpper = word.charAt(0)>='A' && word.charAt(0)<='Z';
        if ((lowerCount==word.length()&&upperCount==0) || (lowerCount==0&&upperCount==word.length()) || (lowerCount==word.length()-1&&isFirUpper)) {
			isCapital = true;
		}
        return isCapital;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
