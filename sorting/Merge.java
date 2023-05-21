package sorting;
public class Merge<T extends Comparable<T>> {

    public void mergeSort(T[] array) {
        if (array == null || array.length <= 1)
            return;

        T[] aux = (T[]) new Comparable[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private void mergeSort(T[] array, T[] aux, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(array, aux, lo, mid); 
        mergeSort(array, aux, mid + 1, hi); 
        merge(array, aux, lo, mid, hi); 
    }

    private void merge(T[] array, T[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = array[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = aux[j++];
            else if (j > hi)
                array[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)
                array[k] = aux[j++];
            else
                array[k] = aux[i++];
        }
    }
}
