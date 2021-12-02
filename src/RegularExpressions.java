import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressions {
    public static void main(String ags[]){
        System.out.println("Задача mail_Check");
        mail("name@gmail.com");
        mail("name@gmail.c");
        mail("@gmail.com");
        mail("name@gmailcom");
        mail("namgmail.com");
        mail("nak23?8me@gmail.com");
        mail("na2893__me@gmail.com");

        System.out.println("Задача time_Check");
        time("17:03");
        time("157:03");
        time("17:3");
        time("17:0jf3");
        time("1703");

        System.out.println("Задача space_Check");
        System.out.println(spaces("Это строка , у которой зачем-то написаны два пробела перед запятой"));

        System.out.println("Задача space_exchange");
        System.out.println(exchange("Какая-то сине-зеленовая трава"));

        System.out.println("Задача KOT");
        System.out.println(cats("Кот который кот и КоТ и КотКОТ и котокот"));
    }

    private static void mail(String str) {
        boolean[] results = new boolean[3];
        Pattern p1 = Pattern.compile("^([a-z]+)@([a-z]+\\.)([a-z]{2,4})$");
        Pattern p2 = Pattern.compile("^([a-z0-9-_]+)@([a-z0-9-_]+\\.)([a-z]{2,4})$");
        Pattern p3 = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher m1 = p1.matcher(str);
        Matcher m2 = p2.matcher(str);
        Matcher m3 = p3.matcher(str);
        results[0] = m1.find();
        results[1] = m2.find();
        results[2] = m3.find();
        System.out.println(Arrays.toString(results));
    }

    private static void time(String str) {
        Pattern p1 = Pattern.compile("^\\d\\d:\\d\\d$");
        Matcher m1 = p1.matcher(str);
        System.out.println(m1.find());
    }

    private static String spaces(String str) {
        return str.replaceAll("\\s*,\\s*", ", ");
    }

    private static String exchange(String str) {
        return str.replaceAll("([а-яА-Я]+)(-)([а-яА-Я]+)", "$3$2$1");
    }

    private static int cats(String str) {
        Pattern p = Pattern.compile("(\\s|^)кот(\\s|$)", Pattern.CASE_INSENSITIVE + Pattern.MULTILINE + Pattern.UNICODE_CASE);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

}
