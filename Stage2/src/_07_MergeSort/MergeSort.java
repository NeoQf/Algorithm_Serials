package _07_MergeSort;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    /**
     * 自顶向下的归并排序算法
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] help = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, help);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r,  E[] help) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, help);
        sort(arr, mid + 1, r, help);

        // 只有当前一段的最后一个元素比后一段第一个元素还要大时，才调用merge函数
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, help);
        }
    }

    /**
     * 自底向上
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] help = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {

            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min((i + sz + sz - 1), n - 1), help);
                }
            }
        }
    }

    /**
     * 合并两个有序的区间arr[l..mid]和arr[mid+1，r]
     * 这里用的左神的方法
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] help) {
        // E[] help = Arrays.copyOfRange(arr, l, r + 1);

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
