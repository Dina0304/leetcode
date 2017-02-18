package WordLadderII126;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

/**
 * 
 * @author Dina
 *思路：判断wordList中哪些单词与beginWord只差一个字母，分别将beginWord变成该单词，并且将该单词从wordList中剔除，并加入到returnList中。
 *单词中更改过的字母后续不会再更改
 *判断beginWord与endWord是否只差一个字母，如果是，则直接将beginWord变成endWord，结束。
 *比较returnList长短，输出最短的。
 */
public class WordLadderIIV1 {
	/**
	 * 判断两个单词是否只有一个字母不相同
	 * 若startWord与endWord只差一个字母，则直接将beginWord变成endWord，结束。
	 * 若midWord与wordList中单词只差一个字母，则将beginWord变成该单词，并且将该单词从wordList中剔除，并加入到returnList中。
	 * @param beginWord
	 * @param endWord
	 * @return
	 */
	public static boolean justOneDiff(String beginWord, String endWord) {
		boolean isJustOneDiff = false;
		int count=0;
		for (int i = 0; i < beginWord.length(); i++) {
			if (beginWord.charAt(i)!=endWord.charAt(i)) {
				count++;
			}
		}

		if (count==1) {
			isJustOneDiff=true;
		}
		return isJustOneDiff;
	}
	/**
	 * 返回wordList中与begin只差一个字母的第一个单词
	 * @param beginWord
	 * @param wordList
	 * @return
	 */
	public static List<String> getOneDiffWords(String beginWord, Set<String> wordList) {
		List<String> strList = new ArrayList<String>();
		String word = null;
		int count = 0;
		Iterator<String> iterator = wordList.iterator();
		while (iterator.hasNext()) {
			word = iterator.next();
			for (int i = 0; i < beginWord.length(); i++) {
				if (beginWord.charAt(i)!=word.charAt(i)) {
					count++;
				}
			}
			if (count==1) {
				strList.add(word);
			}
			count = 0;
		}
		
		return strList;
	}
	
	public static String recursion(String beginWord, String endWord) {
		String word = null;
		if (justOneDiff(beginWord, endWord)) {
			return endWord;
		}else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		int len = beginWord.length();
		List<List<String>> lists = new LinkedList<List<String>>();
		Set<String> midSet = wordList;//可从该集合中删掉已加入最终lists的单词
		List<String> midList = new LinkedList<String>();//最终lists的子list
		midList.add(beginWord);
		String word = null;
		List<String> strList = new ArrayList<String>();//存放所有与beginWord有一个字母不相同的单词
		strList = getOneDiffWords(beginWord, wordList);
		for (int i = 0; i<strList.size() && len>0; i++) {
			len--;
			midList.add(strList.get(i));
			lists.set(i, midList);
			beginWord = strList.get(i);
			if (len>0) {
				for (int j = 0; j < getOneDiffWords(beginWord, wordList).size(); j++) {
					
				}
			}else {
				
			}
			
		}
		
		while (!justOneDiff(beginWord, endWord)) {
			strList = getOneDiffWords(beginWord, wordList);
			Iterator<String> it = strList.iterator();
			while (it.hasNext()) {
				word = it.next();
				midList.add(word);
				midSet.remove(word);
				beginWord = word;
				if(justOneDiff(beginWord, endWord)) {
					midList.add(endWord);
					break;
				}
			}
		}
		
		
		/*while (it.hasNext()) {
			
			while (!justOneDiff(beginWord, endWord)) {
				word = it.next();
				midList.add(word);
				midSet.remove(word);
				beginWord = word;
			}
			
		}*/
		
		if (justOneDiff(beginWord, endWord)) {
			midList.add(beginWord);
			midList.add(endWord);
		}
		lists.add(midList);
		
		midList = new LinkedList<String>();
		if (justOneDiff(beginWord, endWord)) {
			midList.add(beginWord);
			midList.add(endWord);
		}
		lists.add(midList);
		
		
		return lists;
    }

	public static <E> void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		List<String> strList = new ArrayList<String>();
		strList = getOneDiffWords(beginWord, wordList);
		System.out.println(strList);
		List<List<String>> lists = new LinkedList<List<String>>();
		lists.add(strList);
		System.out.println(lists.get(0));
		
//		System.out.println(justOneDiff(beginWord,endWord));
//		List<List<String>> lists = null;
//		lists = findLadders(beginWord, endWord, wordList);
//		System.out.println(lists);
	}

}
