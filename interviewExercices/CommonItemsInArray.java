package interviewExercices;

import java.util.HashSet;
import java.util.Set;

public class CommonItemsInArray {
    /*
     * Given 2 arrays, create a function that let's user know (true / false)
     * whether these two arrays contain any common items
     * 
     * for example: 
     * array1 = {a, b, c, d}
     * array2 = {z, x, i}
     * return false;
     * 
     * Your code will be considered correct if it meets the following criteria:
     * 1: it's readble
     * 2: Good time complexity
     * 3: Good space complexity
     */

    public static boolean commonItemsInArray(char[] vector1, char[] vector2) {
        Set<Character> set = new HashSet<>();

        
        for (char item : vector1) {
            set.add(item);
        }

        for (char item : vector2) {
            if (set.contains(item)) {
                return true;
            }
        }

        return false;
    }
}
