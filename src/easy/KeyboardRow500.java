package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow500 {
	public static String[] findWords(String[] words) {
		String frow = "qwertyuiop";
		String srow = "asdfghjkl";
		String trow = "zxcvbnm";
		Set<Character> fSet = new HashSet<Character>();
		Set<Character> sSet = new HashSet<Character>();
		Set<Character> tSet = new HashSet<Character>();
		for (int i = 0; i < frow.length(); i++) {
			fSet.add(frow.charAt(i));
		}
		for (int i = 0; i < srow.length(); i++) {
			sSet.add(srow.charAt(i));
		}
		for (int i = 0; i < trow.length(); i++) {
			tSet.add(trow.charAt(i));
		}
		List<String> resultList = new ArrayList<String>();
		
		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			String originWord = words[i];
			String word = words[i].toLowerCase();
			char[] wchar = word.toCharArray();
			for (int j = 0; j < wchar.length; j++) {
				if (!fSet.contains(wchar[j])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				resultList.add(originWord);
				continue;
			}
			flag = true;
			for (int j = 0; j < wchar.length; j++) {
				if (!sSet.contains(wchar[j])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				resultList.add(originWord);
				continue;
			}
			flag = true;
			for (int j = 0; j < wchar.length; j++) {
				if (!tSet.contains(wchar[j])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				resultList.add(originWord);
				continue;
			}
		}
		String[] resultWords = new String[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			resultWords[i] = resultList.get(i);
		}
		return resultWords;
        
    }
	
	public static String[] getWords(String[] words) {
		String[] rowWords= {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		List<String> resultList = new ArrayList<String>();
		for (String originWord : words) {
			String word = originWord.toLowerCase();
			boolean flag = true;
			int index = 0;
			for (int i = 0; i < rowWords.length; i++) {
				if (rowWords[i].contains(word.charAt(0)+"")) {
					break;
				}
				index++;
			}
			for (int i = 0; i < word.length(); i++) {
				if (!rowWords[index].contains(word.charAt(i)+"")) {
					flag = false;
					break;
				}
			}
			if (flag) {
				resultList.add(originWord);
			}
		}
		return resultList.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		String[] testStrings = {"Hello", "Alaska", "Dad", "Peace"};
		String[] resultStrings = getWords(testStrings);
		for (int i = 0; i < resultStrings.length; i++) {
			System.out.println(resultStrings[i]);
		}
	}

}
