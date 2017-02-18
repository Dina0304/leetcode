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
 *˼·���ж�wordList����Щ������beginWordֻ��һ����ĸ���ֱ�beginWord��ɸõ��ʣ����ҽ��õ��ʴ�wordList���޳��������뵽returnList�С�
 *�����и��Ĺ�����ĸ���������ٸ���
 *�ж�beginWord��endWord�Ƿ�ֻ��һ����ĸ������ǣ���ֱ�ӽ�beginWord���endWord��������
 *�Ƚ�returnList���̣������̵ġ�
 */
public class WordLadderIIV1 {
	/**
	 * �ж����������Ƿ�ֻ��һ����ĸ����ͬ
	 * ��startWord��endWordֻ��һ����ĸ����ֱ�ӽ�beginWord���endWord��������
	 * ��midWord��wordList�е���ֻ��һ����ĸ����beginWord��ɸõ��ʣ����ҽ��õ��ʴ�wordList���޳��������뵽returnList�С�
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
	 * ����wordList����beginֻ��һ����ĸ�ĵ�һ������
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
		Set<String> midSet = wordList;//�ɴӸü�����ɾ���Ѽ�������lists�ĵ���
		List<String> midList = new LinkedList<String>();//����lists����list
		midList.add(beginWord);
		String word = null;
		List<String> strList = new ArrayList<String>();//���������beginWord��һ����ĸ����ͬ�ĵ���
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
