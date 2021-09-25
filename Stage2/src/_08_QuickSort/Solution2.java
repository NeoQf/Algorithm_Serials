package _08_QuickSort;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;

import static _08_QuickSort.Solution1.swap;

public class Solution2 {
    private Solution2() {}

    public static void quickSort2(int[] arr) {
        Random rnd = new Random();
        quickSort2(arr, 0, arr.length - 1, rnd);
    }

    public static void quickSort2(int[] arr, int L, int R, Random rnd) {
        if (L >= R) {
            return;
        }
        int p = partition2(arr, L, R, rnd);
        quickSort2(arr, L, p - 1, rnd);
        quickSort2(arr, p + 1, R, rnd);
    }

    public static int partition2(int[] arr, int L, int R, Random rnd) {
        int p = L + rnd.nextInt(R - L + 1);
        swap(arr, L, p);
        int i = L;
        int j = R;
        while (true) {
            while (i <= j && arr[i] < arr[L]) {
                i++;
            }

            while (j >= i && arr[j] > arr[L]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, L, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 2, 3, 8, 7, 1};
        quickSort2(arr);

        System.out.println(Arrays.toString(arr));
    }
}
