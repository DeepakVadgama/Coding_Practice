package leetcode;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {


    }

    public List<Interval> merge(List<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(i -> i.start));
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval current : intervals) {

            if (merged.isEmpty() || current.start > merged.getLast().end) {
                merged.add(current);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, current.end);
            }
        }
        return merged;
    }

    private class Interval {
        int start;
        int end;
    }
}
