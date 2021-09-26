package _09_BinarySearch;

// 二分查找非递归实现
public class BinarySearch1 {
    private BinarySearch1() {}

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        // 循环不变量：保持算法恒定在data[l, r]的范围中查找target；
        // 所以关键是根据大小来更新l/r。
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
