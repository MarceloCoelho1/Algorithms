package recursion;

public class ReverseString {

    public static String reverseString(String input) {
        // what is the base case?
        if(input.equals("")) {
            return "";
        }
        
        // what is the smallest amount of work i can do in each iteration;
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        String response = ReverseString.reverseString("marcelo");
        System.out.println(response);
    }
}