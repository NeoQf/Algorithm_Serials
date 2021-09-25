package _08_QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Solution1 {
    private Solution1() {}

    public static void quickSort1(int[] arr) {
        Random rnd = new Random();
        quickSort1(arr, 0, arr.length - 1, rnd);
    }

    public static void quickSort1(int[] arr, int L, int R, Random rnd) {
        // 递归到底时，此区间内没有元素或者只有1个元素，那么就不需要继续往下递归，直接结束即可。
        if (L >= R) {
            return;
        }
        int p = partition1(arr, L, R, rnd);
        quickSort1(arr, L, p - 1, rnd);
        quickSort1(arr, p + 1, R, rnd);
    }

    public static int partition1(int[] arr, int L, int R, Random rnd) {
        int j = L;

        int p = L + rnd.nextInt(R - L + 1);
        swap(arr, L, p);

        for (int i = L + 1; i <= R; i++) {
            if (arr[i] < arr[L]) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, j, L);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 2, 3, 8, 7, 1};
        quickSort1(arr);

        System.out.println(Arrays.toString(arr));
    }
}
