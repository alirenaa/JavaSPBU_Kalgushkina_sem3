package oop;

public class Rational {
    private int n;
    private int d;

    static Rational ONE = new Rational(1);
    static Rational ZERO = new Rational(0);

    private static int GCD(int n, int d)  {
        int a = Math.abs(n);
        int b = Math.abs(d);
        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }

        return a + b;
    }


    Rational(int n, int d) {
        if (d != 0) {
            int gcd = GCD(n, d);
            n = n / gcd;
            d = d / gcd;
            this.n = n;
            this.d = d;
        }
    }

    Rational(int n) {
        this.n = n;
        this.d = 1;
    }

    public String toString() {
        String answ = "";
        if (n == 0)
            answ = "0";
        else if (d == 1)
            answ = Integer.toString(n);
        else
            answ = Integer.toString(n) + "/" + Integer.toString(d);
        return answ;
    }

    public double toDouble() {
        return (double)n/d;
    }

    public Rational add(Rational x) {
        return new Rational(this.n * x.d + this.d * x.n, this.d * x.d);
    }

    public Rational sub(Rational x) {
        return new Rational(this.n * x.d - this.d * x.n, this.d * x.d);
    }

    public Rational mul(Rational x) {
        return new Rational(this.n * x.n, this.d * x.d);
    }

    public Rational div(Rational x) {
        return new Rational(this.n * x.d, this.d * x.n);
    }
}
