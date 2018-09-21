package teaching.streams;

import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("all")
public class IntSortStream3 {


    public static void main(String[] args) {

        int[] numbers = {4, 1, 13, 90, 16, 2, 0};

        IntStream.of(numbers);          // from array
        IntStream.range(1, 101);        // 1..100
        IntStream.rangeClosed(1, 100);  // 1..100
        IntStream.generate(supplier()); // from supplier

        IntStream.of(numbers).distinct();                  // distinct    
        IntStream.of(numbers).sorted();                    // sort
        IntStream.of(numbers).limit(3);                    // get first 3
        IntStream.of(numbers).skip(3);                     // skip first 3
        IntStream.of(numbers).filter(num -> num % 2 == 0); // only even
        IntStream.of(numbers).map(num -> num * 2);         // double each num
        IntStream.of(numbers).boxed();                     // convert each num to Integer

        IntStream.of(numbers).average(); // average
        IntStream.of(numbers).min();     // min
        IntStream.of(numbers).max();     // max
        IntStream.of(numbers).sum();     // sum
        IntStream.of(numbers).count();   // count

        IntStream.range(1, 100).forEach(System.out::println);         // print 1 to 99
        IntStream.range(1, 100).toArray();                            // collect into array
        IntStream.range(1, 100).boxed().collect(Collectors.toList()); // collect into list                        // action for each num

        IntStream.of(numbers).anyMatch(num -> num % 2 == 1);  // is any num odd
        IntStream.of(numbers).allMatch(num -> num % 2 == 1);  // are all num odd


    }

    private static IntUnaryOperator convertToString() {
        return null;
    }

    private static IntPredicate isOddNumber() {
        return null;
    }

    private static IntSupplier supplier() {
        return null;
    }

    private static int getNextInteger() {
        return 0;
    }

}
