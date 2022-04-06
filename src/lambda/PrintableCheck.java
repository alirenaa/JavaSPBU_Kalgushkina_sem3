package lambda;

public class PrintableCheck {
    public static void main(String[] args) {
        lambda.Drawing pic = new lambda.Drawing(30, 24, '⣿');

        pic.drawVerticalLine(2, 1, 22, '⠄');
        pic.drawVerticalLine(26, 1, 22, '⠄');
        pic.drawHorizontalLine(2, 27, 1, '⠄');
        pic.drawHorizontalLine(2, 27, 22, '⠄');
        pic.setPoint(16, 11, '-');

        pic.print();
        System.out.println();

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print();

        PrintableString ps = new PrintableString("asdf");
        ps.print();

        Printable anon = new Printable() {
            @Override
            public void print() {
                System.out.println("anon");
            }
        };

        Printable lambda = () -> System.out.println("lambda!");

        Printable[] array = new Printable[]{pic, pl, ps, anon, lambda};
        for (Printable i: array) {
            i.print();
        }

    }
}
