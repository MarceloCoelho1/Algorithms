package binarySearch;

public class main {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int response = BinarySearch.search(3, numeros);
        System.out.println(response);
    }
}
