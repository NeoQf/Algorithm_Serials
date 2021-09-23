package _07_MergeSort;

class Solution {
    private int res = 0;

    public int reversePairs(int[] nums) {
        int[] help = new int[nums.length];

        res = 0;
        sort(nums, 0, nums.length - 1, help);
        return res;
    }

    private void sort(int[] arr, int l, int r, int[] help) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, help);
        sort(arr, mid + 1, r, help);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, help);
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int[] help) {
        // E[] help = Arrays.copyOfRange(arr, l, r + 1);

        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        // 双指针，谁小填谁
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
                res += mid - p1 + 1;
            }
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
