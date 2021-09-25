package _08_QuickSort;

import java.util.Arrays;
import java.util.Random;

import static _08_QuickSort.Solution1.swap;

public class Solution3 {
    private Solution3() {}

    public static void quickSort3(int[] arr) {
        Random rnd = new Random();
        quickSort3(arr, 0, arr.length - 1, rnd);
    }



    public static void quickSort3(int[] arr, int L, int R, Random rnd) {
        if (L >= R) {
            return;
        }

        int p = L + rnd.nextInt(R - L + 1);
        swap(arr, L, p);

        int Lt = L;
        int i = L + 1;
        int gt = R + 1;

        // 因为i并不此每次都加1，如i处元素大于标定点元素时，就不能加1；
        // 所以这里不能写for循环，只能写while循环，这与双路快排一致。
        while (i < gt) {
            if (arr[i] < arr[L]) {
                Lt++;
                swap(arr, i, Lt);
                i++;
            } else if (arr[i] > arr[L]) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, L, Lt);

        quickSort3(arr, L, Lt - 1, rnd);
        quickSort3(arr, gt, R, rnd);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 2, 3, 8, 7, 1};
        quickSort3(arr);

        System.out.println(Arrays.toString(arr));
    }
}
