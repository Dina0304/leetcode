package ShenZhouXinXi;

import java.util.Scanner;

/**
 * Created by dina on 17/10/15.
 */
public class Two {
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    /**
     * 选择枢轴
     * @param arr
     * @param l
     * @param r
     */
    public static void pivot(int[] arr, int l, int r) {
        int mid = l + (r-l)/2;
        if (arr[mid] > arr[r]) {
            swap(arr, mid, r);
        }
        if (arr[l] > arr[r]) {
            swap(arr, l, r);
        }
        if (arr[mid] > arr[l]) {
            swap(arr, l, mid);
        }
    }
    /**
     * 枢轴l左边都是小于它的数，右边都是大于它的数
     * @param arr
     * @param l
     * @param r
     * @return 枢轴的位置
     */
    public static int patition(int[] arr, int l, int r) {
        int pivot;
        pivot(arr, l, r);
        pivot = arr[l];
        while (l<r) {
            while (l<r && arr[r]>=pivot) {
                r--;
            }
            swap(arr, l, r);
            while (l<r && arr[l]<=pivot) {
                l++;
            }
            swap(arr, l, r);
        }
        return l;
    }

    public static void qsort(int[] arr, int l, int r) {
        int pivot;
        if (l<r) {
            pivot = patition(arr, l, r);
            qsort(arr, l, pivot-1);
            qsort(arr, pivot+1, r);
        }
    }

    public static int strToInt(String str) {
        double res = 0;
        int len = str.length();
        for (int i = 1; i <= len; i++) {
            res += (str.charAt(i-1)-'0') * Math.pow(10, len-i);
        }


        return (int)res;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String in = cin.nextLine();
        String[] strs = in.split(",");
        int len = strs.length;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = strToInt(strs[i]);
        }

        qsort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
