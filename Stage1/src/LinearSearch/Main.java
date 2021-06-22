package LinearSearch;

public class Main {
    public static void main(String[] args) {
         Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
         int res = LS.search(data, 16);
         System.out.println(res);

         Student[] students = {new Student("Alice"),
         new Student("Bobo"),
         new Student("Charles")};

         Student bobo = new Student("Bobo");
         int res1 = LS.search(students, bobo);
         System.out.println(res1);
    }
}
