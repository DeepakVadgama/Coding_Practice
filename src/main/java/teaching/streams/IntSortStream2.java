package teaching.streams;

import java.util.stream.IntStream;

@SuppressWarnings("all")
public class IntSortStream2 {


    public static void main(String[] args) {

        int[] numbers = {4, 1, 13, 90, 16, 2, 0};

        IntStream.of(numbers)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

}
