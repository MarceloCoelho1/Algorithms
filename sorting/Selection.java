package sorting;

public class Selection<T extends Comparable<T>> {

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length; 

        for (int i = 0; i < N; i++) { 
            int min = i; 

            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
                    
            exch(a, i, min);
        }

    }

    private static <T extends Comparable<T>> void show(T[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
