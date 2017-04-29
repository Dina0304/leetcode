package dataStructure;

public class BinSearch {
	public static int binSearch(int[] arr, int item) {
		int l =  0;
		int r = arr.length-1;
		while (l<=r) {
			int m = l + (r-l)/2;
			if (arr[m] > item) {
				r = m-1;
			}else if (arr[m] < item) {
				l = m+1;
			}else {
				return m;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,5};
		int item = 4;
		System.out.println(binSearch(arr, item));
	}

}
