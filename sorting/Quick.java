package sorting;

public class Quick {

    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int j = partition(a, lo, hi); 
        sort(a, lo, j - 1);
        sort(a, j + 1, hi); 
    }

    private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) { 
        int i = lo, j = hi + 1; 
        T v = a[lo]; 
        while (true) { 
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j); 
        return j; 
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
