package dataStructure;

public class BubbleSort {
	public static void bsort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length-i; j++) {
				if (arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,8,3,11,1,19,7};
		bsort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
