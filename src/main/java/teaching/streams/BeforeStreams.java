package teaching.streams;

import java.util.stream.IntStream;

//@SuppressWarnings("All")
public class BeforeStreams {

    public static void main(String[] args) {

        int[] numbers = {4, 1, 13, 90, 16, 2, 0};

//        int min = numbers[0];
//        for (int i = 1; i < numbers.length; i++) {
//            if (min < numbers[i]) {
//                min = numbers[i];
//            }
//        }
//        System.out.println("Minimum is " + min);

        IntStream.of(numbers)
                .min()
                .ifPresent(System.out::println);

        int min = IntStream.of(numbers)
                .min()
                .getAsInt();


    }
}
