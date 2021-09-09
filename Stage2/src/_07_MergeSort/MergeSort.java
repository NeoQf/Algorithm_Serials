package _07_MergeSort;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 合并两个有序的区间间arr[l..mid]和arr[mid+1，r]
     * 这里用的左神的方法
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] help = Arrays.copyOfRange(arr, l, r + 1);

        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        // 双指针，谁小填谁
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1].compareTo(arr[p2]) < 0 ? arr[p1++] : arr[p2++];
        }

        // 走完上一个while之后，以下两个while有且只有一个会越界
        // 越界之后，将另一个数组的剩下部分填入help数组后面
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }
}
