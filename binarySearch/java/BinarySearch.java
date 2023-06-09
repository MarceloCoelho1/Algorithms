package binarySearch.java;
public class BinarySearch {

    public static int search(int key, int a[]) {
        return search(key, a, 0, a.length - 1);
    }

    private static int search(int key, int a[], int lo, int hi) {
        if (lo > hi)
            return -1;
            
        int mid = lo + (hi - lo) / 2;

        if (key < a[mid])
            return search(key, a, lo, mid - 1);
        else if (key > a[mid])
            return search(key, a, mid + 1, hi);
        else
            return mid;

    }

}