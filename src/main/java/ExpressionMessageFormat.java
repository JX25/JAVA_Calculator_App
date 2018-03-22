import java.text.MessageFormat;
import java.text.ParsePosition;

public class ExpressionMessageFormat{

    public static String returnExpression(String dzialanie, String wynik)
    {
        String text = java.text.MessageFormat.format("{0} \t = {1}\n-------------\n", dzialanie, wynik);
        return text;
    }

}
