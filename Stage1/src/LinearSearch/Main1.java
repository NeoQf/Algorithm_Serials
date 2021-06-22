package LinearSearch;

public class Main1 {

    public static void main(String[] args) {
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
