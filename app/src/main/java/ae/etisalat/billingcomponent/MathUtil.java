package ae.etisalat.billingcomponent;

public class MathUtil {

    public static int round(int number) {

        return ((number + 99) / 100) * 100;
    }
}
