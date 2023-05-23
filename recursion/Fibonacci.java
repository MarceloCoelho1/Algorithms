package recursion;

public class Fibonacci {
    public static int fib(int value) {
        if(value == 0 || value == 1) {
            return value;
        }

        return fib(value - 1) + fib(value - 2);
    }
}
