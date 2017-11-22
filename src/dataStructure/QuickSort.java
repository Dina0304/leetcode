package dataStructure;

public class QuickSort {
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    /**
     * 选择枢轴
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void pivot(int[] arr, int l, int r) {
        int mid = l + (r - l) / 2;
        if(arr[mid] > arr[r]){
            swap(arr, mid, r);
        }
        if(arr[l] > arr[r]){
            swap(arr, l, r);
        }
        if(arr[mid] > arr[l]){
            swap(arr, l, mid);
        }
    }

    /**
     * 枢轴l左边都是小于它的数，右边都是大于它的数
     *
     * @param arr
     * @param l
     * @param r
     * @return 枢轴的位置
     */
    public static int patition(int[] arr, int l, int r) {
        int pivot;
        pivot(arr, l, r);
        pivot = arr[l];
        while(l < r) {
            while(l < r && arr[r] >= pivot) {
                r--;
            }
            swap(arr, l, r);
            while(l < r && arr[l] <= pivot) {
                l++;
            }
            swap(arr, l, r);
        }
        return l;
    }

    public static void qsort(int[] arr, int l, int r) {
        int pivot;
        if(l < r){
            pivot = patition(arr, l, r);
            qsort(arr, l, pivot - 1);
            qsort(arr, pivot + 1, r);
        }
    }


    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 8, 3, 11, 7, 1, 19, 7};
        qsort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
