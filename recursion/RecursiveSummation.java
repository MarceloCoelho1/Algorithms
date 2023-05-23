package recursion;

public class RecursiveSummation {
    

    public static int recusiveSummation(int inputNumber) {
        if(inputNumber <= 1)
            return inputNumber;

        return inputNumber + recusiveSummation(inputNumber - 1);
    }

}
