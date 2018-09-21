package teaching.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

@SuppressWarnings("ALL")
public class IntStreams {


    public static void main(String[] args) {

//        int[] numbers = {4, 1, 13, 90, 16, 2, 0};
//
//        IntStream.of(numbers).min();
//        IntStream.of(numbers).max();
//        IntStream.of(numbers).average();
//        IntStream.of(numbers).count();
//        IntStream.of(numbers).sum();

        int[] numbers = {4, 1, 13, 90, 16, 2, 0};

        IntSummaryStatistics stats
                = IntStream.of(numbers).summaryStatistics();

        stats.getMin();
        stats.getMax();
        stats.getAverage();
        stats.getCount();
        stats.getSum();
    }
}
