package sorting;

public class Insertion {

    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) { 
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer []numbers = {2, 3, 4, 6, 9, 1};

        Insertion.sort(numbers);
    
    }
}
