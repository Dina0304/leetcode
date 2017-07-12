package easy;

public class ShortestWordDistance243 {
	public static int shortestDistance(String[] words, String word1, String word2) {
		if(words==null || words.length==0) return 0;
		int distance = Integer.MAX_VALUE;
		int w1 = -1;
		int w2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				w1 = i;
				if (w2 != -1) {
					distance = Math.min(w1-w2, distance);
				}
			}
			if (words[i].equals(word2)) {
				w2 = i;
				if (w1 != -1) {
					distance = Math.min(w2-w1, distance);
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "coding";
		System.out.println(shortestDistance(words, word1, word2));
	}

}
