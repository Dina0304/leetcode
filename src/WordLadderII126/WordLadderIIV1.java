package WordLadderII126;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author Dina
 *思路：判断wordList中哪些单词与beginWord只差一个字母，分别将beginWord变成该单词，并且将该单词从wordList中剔除，并加入到returnList中。
 *判断beginWord与endWord是否只差一个字母，如果是，则直接将beginWord变成endWord，结束。
 *比较returnList长短，输出最短的。
 */
public class WordLadderIIV1 {
	
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		int lenth = beginWord.length();
		
		return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
