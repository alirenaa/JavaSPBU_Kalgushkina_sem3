public class Intro {
    public static void main(String args[]) {
        System.out.println("Задача Task3Digits");
        System.out.println(Task3Digits(80));
        System.out.println(Task3Digits(387));
        System.out.println(Task3Digits(8039));
        System.out.println("Задача TaskLast5");
        System.out.println(TaskLast5(8039));
        System.out.println(TaskLast5(8035));
        System.out.println("Задача IntroTaskSameDigits");
        System.out.println(IntroTaskSameDigits(8039));
        System.out.println(IntroTaskSameDigits(777));
        System.out.println(IntroTaskSameDigits(8));
        System.out.println("Задача IntroTaskLeap");
        System.out.println(IntroTaskLeap(1998));
        System.out.println(IntroTaskLeap(2024));
        System.out.println("Задача IntroTaskCat");
        System.out.println(IntroTaskCat(1998));
        System.out.println(IntroTaskCat(2024));
        System.out.println(IntroTaskCat(11));
        System.out.println(IntroTaskCat(12361));
        System.out.println("Задача IntroTaskQuadraticEquation");
        System.out.println(IntroTaskQuadraticEquation(0, 0, 4));
        System.out.println(IntroTaskQuadraticEquation(3, -14, -5));
        System.out.println(IntroTaskQuadraticEquation(0, 5, 10));
        System.out.println(IntroTaskQuadraticEquation(1, 0, -4));
        System.out.println("Задача PrimalityTest");
        System.out.println(PrimalityTest(311));
        System.out.println(PrimalityTest(711));
        System.out.println(PrimalityTest(1));
    }

    private static boolean Task3Digits(int a) {
        return a >= 100 && a <= 999;
    }

    private static boolean TaskLast5(int b) {
        return b % 10 == 5;
    }

    private static boolean IntroTaskSameDigits(int c) {
        int first = (c % 100) / 10;
        int second = c % 10;
        return first == second;
    }

    private static boolean IntroTaskLeap(int d) {
        return d % 4 == 0;
    }

    private static String IntroTaskCat(int cats) {
        if (cats % 10 == 1 && cats % 100 != 11) {
            return cats + " кот";
        } else if (cats % 10 == 2 && cats % 100 != 12 || cats % 10 == 3 && cats % 100 != 13 || cats % 10 == 4 && cats % 100 != 14) {
            return cats + " кота";
        } else {
            return cats + " котов";
        }
    }

    private static String IntroTaskQuadraticEquation(int k1, int k2, int k3) {
        if (k1 == 0 && k2 == 0 && k3 == 0) {
            return "решений бесконечно много";
        }
        else if (k1 == 0 && k2 != 0 && k3 != 0) {
            float answ = (-k3)/k2;
            return "одно решение x=" + answ;
        }
        else if (k1 == 0 && k2 == 0 && k3 != 0) {
            return "решений нет";
        }
        else {
            float D = k2 * k2 - 4 * k1 * k3;
            if (D < 0) {
                return "решений нет";
            }
            else if (D == 0) {
                float answ = (-k2)/(2 * k1);
                return "одно решение x=" + answ;
            }
            else {
                float answ1 = (float) ((Math.sqrt(D)-k2)/(2 * k1));
                float answ2 = (float) ((-Math.sqrt(D)-k2)/(2 * k1));
                return "два решения x1=" + answ1 + " x2=" + answ2;
            }
        }

    }

    private static boolean PrimalityTest(int numb) {
        if (numb < 2)
            return true;
        double sqrt = Math.sqrt(numb);
        for (int i = 2; i <= sqrt; i++) {
            if (numb % i == 0)
                return false;
        }
        return true;
    }

}

