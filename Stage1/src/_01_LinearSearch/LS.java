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
}
