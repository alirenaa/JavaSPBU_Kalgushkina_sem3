public class Fibonacci {
    public static void main(String args[]) {
        calculation(10);
    }

    public static void calculation(int n) {
        Matrix22 matrix = new Matrix22(1, 1, 1, 0);
        System.out.println(matrix.pow(n).getArray()[0][1]);
    }

}
