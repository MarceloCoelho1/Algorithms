package recursion;

public class findBinary {

    public static String decimalToBinary(int number) {
       return decimalToBinary(number, "");
    }

    private static String decimalToBinary(int number, String result) {
        if(number == 0) {
            return result;
        }

        result = number % 2 + result;

        return decimalToBinary(number / 2, result);
    }
}
