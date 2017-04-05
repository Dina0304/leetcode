package easy;


public class QuickSort {
	public static void quickSort(int[] arr, int l, int r) {
		if(l<r) {
			int tmp = arr[l];
			int i = l, j = r;
			while(i<j) {
				while(i<j && arr[j]>tmp) 
					j--;
				if(i<j)
					arr[i++] = arr[j];
				while(i<j && arr[i]<=tmp)
					i++;
				if(i<j)
					arr[j--] = arr[i];
			}
			arr[i] = tmp;
			quickSort(arr, l, i-1);
			quickSort(arr, i+1, r);
		}
	}
	public static void main(String[] args) {
		int[] result = {3,5,1,2,6,4};
		quickSort(result, 0, result.length-1);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
