package _02_Sorting._1_SelectionSort;

public class SST_generic {
    private SST_generic() {}

    // 循环不变量：arr[0...i) 是有序的；arr[i...n)时无序的
    // 对泛型进行约束，必须要是可比较的
    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 对于泛型，其数据类型应该是类，而不能为基本数据类型;
        // 所以声明为int的包装类Integer
        // int[] arr = {1, 4, 2, 3, 6, 5};
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SST_generic.sort1(arr);
        for (int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }
}
