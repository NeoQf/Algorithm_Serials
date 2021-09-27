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

    /**
     * 查找大于target的最小值的索引
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;

        // 在data[l, r]中寻找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * >target，返回最小值索引I
     * == target，返回最大索引
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 > 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    // <target 的最大值索引
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;

        // 在data[l, r]中寻找解
        while (l < r) {
            // 下取整，若不加1，则会导致bug；
            // 所以加1，调整为上取整。
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
