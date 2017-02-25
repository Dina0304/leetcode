package easy;

public class DetectCapital520 {
	/*public boolean detectCapitalUse(String word) {
        boolean isCapital = false;
        word.matches("(a-z)+|(A-Z)+|(A-Z)");
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
    }*/
	/*public static boolean detectCapitalUse(String word) {
        boolean isCapital = word.matches("[a-z]+|[A-Z]+|[A-Z][a-z]+");
        return isCapital;
    }*/
	
	public static boolean detectCapitalUse(String word) {
		if(word.length() < 2) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
			return true;
		}
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
			return true;
		}
        return false;
    }

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("ABCee"));

	}

}
