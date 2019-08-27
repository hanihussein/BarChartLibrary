package ae.etisalat.billingcomponent.library.util;

public class MathUtil {

    public static int round(int number) {

        return ((number + 99) / 100) * 100;
    }
}
