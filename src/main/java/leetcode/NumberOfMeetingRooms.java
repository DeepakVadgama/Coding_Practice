package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfMeetingRooms {

    public static void main(String[] args) {

    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));

        PriorityQueue<Integer> minEndTimes = new PriorityQueue<>();
        minEndTimes.offer(intervals.get(0).end);
        for (Interval interval : intervals) {

            if (interval.start >= minEndTimes.peek()) {
                minEndTimes.poll();
                minEndTimes.offer(interval.end);
            } else {
                minEndTimes.offer(interval.end);
            }
        }

        return minEndTimes.size();
    }

    private class Interval {
        int start;
        int end;
    }
}
