package _01_LinearSearch;

public class LS {
    // 构造函数设置成private，这样一来，就阻止了用户（在新的类中）创建此类的对象
    // （与下面设置为静态方法联系起来）如果是在此类的main函数下，仍然可以创建类的对象，因为是类内部方法
    private LS() {}

    // 设置成静态变量，无需再在main函数创建类的对象，可直接调用
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        /**学生类：
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int res = LS.search(data, 16);
        System.out.println(res);

        Student[] students = {new Student("Alice"),
                new Student("Bobo"),
                new Student("Charles")};

        Student bobo = new Student("Bobo");
        int res1 = LS.search(students, bobo);
        System.out.println(res1);
        */
        int[] dataSize = {1000000, 10000000, 100000000};
//        int n = 100000;
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++)
                LS.search(data, n);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
        }


    }
}
