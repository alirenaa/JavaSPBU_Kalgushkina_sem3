package lambda;

public class PrintableString implements Printable{
    private String str;

    PrintableString(String str_) {
        this.str = str_;
    }

    @Override
    public void print() {
        System.out.println(str);
    }
}
