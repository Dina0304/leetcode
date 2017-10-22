package easy;

public class ValidWordAbbreviation408 {
	public static boolean isAbbrev(String a, String b) {
		if(a==null || b==null) return false;
		int i = 0; 
		int j = 0;
		while(i<a.length() && j<b.length()) {
			if(a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
				continue;
			}
			if(b.charAt(j)<'0' || b.charAt(j)>'9') {
				return false;
			}
			
			int start = j;
			while(j<b.length() && b.charAt(j)>='0' && b.charAt(j)<='9') {
				j++;
			}
			
			String tmp = b.substring(start,j);
			if(tmp.charAt(0)=='0') return false;
			i = i+Integer.parseInt(tmp);
		}
		return a.length()==i && b.length()==j;
	}
	
	public static boolean amazingAbbr(String word, String abbr) {
		return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
	}
	
	public static void main(String[] args) {
		String word = "word";
		String abbr = "w2d";
		System.out.println(isAbbrev(word, abbr));
		System.out.println(amazingAbbr(word, abbr));
	}
}
