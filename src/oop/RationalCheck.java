package oop;

public class RationalCheck {
    public static void main(String[] args) {
        Rational x = new Rational(4, 6);
        System.out.println(x.toString());
        System.out.println(x.toDouble());

        Rational y = new Rational(3);
        System.out.println(y.toString());
        System.out.println(x.add(y).toString());
        System.out.println(x.sub(y).toString());
        System.out.println(x.mul(y).toString());
        System.out.println(x.div(y).toString());


        System.out.println(func(1).toString());
        System.out.println(func(3).toDouble());
        System.out.println(func(20).toDouble());
        //выводит 0.8302753773574207, на 19-ом шаге получаем x = 275295799/77597520, проверим:

        Rational a = new Rational(275295799, 77597520);
        System.out.println((long)275295799 * 20 + 77597520 * 1);
        // максимальное значение для int  2 147 483 647, мы же получили 5 583 513 500
    }

    public static Rational func(int n) {
        Rational x = new Rational(0);
        for (int i = 1; i < n+1; i++) {
            x = x.add(new Rational(1, i));
        }
        return x;
    }

}
