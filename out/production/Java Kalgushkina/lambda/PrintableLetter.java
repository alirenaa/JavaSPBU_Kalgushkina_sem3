package lambda;

public class PrintableLetter implements Printable{
        private String symb;
        private int count;

        PrintableLetter(String symb_, int count_) {
            this.symb = symb_;
            this.count = count_;
        }

        @Override
        public void print() {
            System.out.println(symb.repeat(count));
        }
}
