import java.util.Arrays;

public class ArraysTasks {
    public static void main(String args[]) {
        System.out.println("Задача even");
        System.out.println(Arrays.toString(even(4)));
        System.out.println(Arrays.toString(even(7)));
        System.out.println("Задача allSimilar");
        System.out.println(allSimilar(new int[]{10, 10, 20}));
        System.out.println(allSimilar(new int[]{10, 10, 10}));
        System.out.println(allSimilar(new int[]{10}));
        System.out.println("Задача hasSimilar");
        System.out.println(hasSimilar(new int[]{10, 10, 20}));
        System.out.println(hasSimilar(new int[]{10, 20, 30}));
        System.out.println(hasSimilar(new int[]{10}));
        System.out.println("Задача mean");
        System.out.println(mean(new int[]{10, 43, 20}));
        System.out.println(mean(new int[]{30}));
        System.out.println("Задача shift");
        shift(new int[]{10, 43, 20});
        System.out.println("Задача copyShift");
        System.out.println(Arrays.toString(copyShift(new int[]{10, 43, 20})));

    }

    private static int[] even(int n) {
        int[] nums = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            nums[i] = (i+1)*2;
        }
        return nums;
    }

    private static boolean allSimilar(int[] a) {
        int temp = a[0];
        for (int x : a) {
            if (x != temp) { return false; }
        }
        return true;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                return (a[i] == a[j]);
            }
        }
        return false;
    }

    private static double mean(int[] a) {
        double sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum/a.length;
    }

    private static void shift(int[] a) {
        int temp2 = a[a.length-1];
        int temp1;
        for (int i = 0; i < a.length; i++) {
            temp1 = temp2;
            temp2 = a[i];
            a[i] = temp1;
        }
        System.out.println(Arrays.toString(a));
    }

    private static int[] copyShift(int[] a) {
        int[] nums = new int[a.length];
        nums[0] = a[a.length-1];
        for (int i = 0; i < a.length - 1; i++) {
            nums[i+1] = a[i];
        }
        return nums;
    }
}
