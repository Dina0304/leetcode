package dataStructure;

public class HeapSort {
    public static void hSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            buildHeap(arr, len - 1 - i);
            swap(arr, 0, len - 1 - i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void buildHeap(int[] arr, int lastIndex) {
        for(int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while(2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;
                if(biggerIndex < lastIndex){
                    if(arr[biggerIndex] < arr[biggerIndex + 1]){
                        biggerIndex++;
                    }
                }
                if(arr[biggerIndex] > arr[k]){
                    swap(arr, biggerIndex, k);
                    k = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 3, 11, 1, 19, 7};
        hSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
