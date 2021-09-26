package _08_QuickSort;

import java.util.Arrays;
import java.util.Random;

import static _08_QuickSort.Solution1.swap;

public class Solution3_1 {
    private Solution3_1() {}

    public static void quickSort3_1(int[] arr) {
        Random rnd = new Random();
        quickSort3_1(arr, 0, arr.length - 1, rnd);
    }

    /**
     * 如果要将三路快排写成单路和双路的形式，那么就需要quickSort3返回两个元素。为什么？
     *      ——因为：单路和双路都是只需要得到一个分隔点p，
     *      用以分隔开小于（[0, p - 1]）和大于（[p + 1, arr.length - 1]）标定点的部分，
     *      然后分别对两侧进行递归即可；
     *
     *
     *      而三路快排则是将数组分割为3个部分（小于等于大于），
     *      而其中等于的部分不需要再进行递归，
     *      只需要对两侧的小于和大于部分继续递归即可，
     *      左侧的话，从零位置开始到位置Lt，是小于的部分——[0, Lt]；
     *      右侧的话，从位置gt开始，直到位置arr.length-1即数组结束，是大于的部分——[gt, arr.length - 1]；
     *      所以需要quickSort3返回两个元素，那么其返回值类型需要写成数组int[]。
     * @param arr
     * @param L
     * @param R
     * @param rnd
     */
    public static void quickSort3_1(int[] arr, int L, int R, Random rnd) {
        if (L >= R) {
            return;
        }

        int[] p = partition3_1(arr, L, R, rnd);
        int Lt = p[0];
        int gt = p[1];
        quickSort3_1(arr, L, Lt, rnd);
        quickSort3_1(arr, gt, R, rnd);
    }

    public static int[] partition3_1(int[] arr, int L, int R, Random rnd) {
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

        return new int[]{Lt, gt};
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 2, 3, 8, 7, 1};
        quickSort3_1(arr);

        System.out.println(Arrays.toString(arr));
    }
}

