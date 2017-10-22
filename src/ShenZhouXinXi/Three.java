package ShenZhouXinXi;

import java.util.Scanner;

/**
 * Created by dina on 17/10/15.
 */
public class Three {

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qsort(arr, low, pivot - 1);
            qsort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;

        return low;
    }

    public static int strToInt(String str) {
        double res = 0;
        int len = str.length();
        for (int i = 1; i <= len; i++) {
            res += (str.charAt(i - 1) - '0') * Math.pow(10, len - i);
        }

        return (int) res;
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

        qsort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
