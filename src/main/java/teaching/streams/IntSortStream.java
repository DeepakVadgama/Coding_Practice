package teaching.streams;

import java.util.Arrays;

public class IntSortStream {


    public static void main(String[] args) {

        int[] numbers = {4, 1, 13, 90, 16, 2, 0};

        // clone 
        int[] copy = Arrays.copyOf(numbers, numbers.length);

        // sort 
        Arrays.sort(copy);

        // pick first 3 
        for (int i = 0; i < 3; i++) {
            System.out.println(copy[i]);
        }
    }
}
