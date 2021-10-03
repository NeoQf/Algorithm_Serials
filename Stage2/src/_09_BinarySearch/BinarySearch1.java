package _09_BinarySearch;

// 二分查找非递归实现
public class BinarySearch1 {
    private BinarySearch1() {}

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int L = 0, R = data.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (data[mid].compareTo(target) < 0) {
                L = mid + 1;
            } else if (data[mid].compareTo(target) > 0) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * upper（上界）：查找大于target  的最小值的索引
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int L = 0, R = data.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (data[mid].compareTo(target) <= 0) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return L;
    }


    /**
     * ceil（天花板）：
     * 若存在等于target，返回target值的最大索引
     * 若不存在target，返回大于target的最小值索引
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

    // 返回target 的最大值索引

    /**
     * lower：下界；
     * 查找小于target的元素中最大的那一个。
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int L = -1, R = data.length - 1;
        while (L < R) {
            int mid = L + (R - L + 1) / 2;
            if (data[mid].compareTo(target) >= 0) {
                R = mid - 1;
            } else {
                L = mid;
            }
        }
        return L;
    }
}
