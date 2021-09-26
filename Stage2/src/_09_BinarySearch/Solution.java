package _09_BinarySearch;

// 二分查找非递归实现
public class Solution {

    public int search(int[] data, int target) {
        int l = 0, r = data.length - 1;

        // 循环不变量：data[l, r]————
        // 保持算法恒定在data[l, r]的范围中查找target；
        // 所以关键是根据大小来更新l/r。
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int search1(int[] data, int target) {
        int l = 0, r = data.length;

        // 循环不变量改为：data[l, r)————
        // 相比前面只是修改了循环不变量的末尾取值；
        // 将右侧闭区间data[l, r]，改为了右侧开区间data[l, r)。
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                l = mid + 1;    // 后续，继续在data[mid+1，r)范围里寻找解
            } else {
                r = mid;    // 后续，继续在data[l，mid)范围里寻找解
            }
        }
        return -1;
    }
}