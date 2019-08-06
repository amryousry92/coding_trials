package coding.practice;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiggestSum {

    static class Interval {

        int start;
        int finish;

        Interval(int s, int f) {
            start = s;
            finish = f;
        }
    }

    public static int widestGap(int n, List<Integer> start, List<Integer> finish) {
        // Write your code here
        final List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            Interval interval = new Interval(start.get(i), finish.get(i));
            intervals.add(interval);
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));
        final List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);
        for (int j = 1; j < intervals.size(); j++) {
            if (intervals.get(j).start <= currentInterval.finish) {
                currentInterval = new Interval(
                    Math.min(currentInterval.start, intervals.get(j).start),
                    Math.max(intervals.get(j).finish, currentInterval.finish));
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = new Interval(intervals.get(j).start, intervals.get(j).finish);
            }
        }
        mergedIntervals.add(currentInterval);
        int maxLength = 0;
        for (int x = 1; x < mergedIntervals.size(); x++) {
            maxLength = Math.max(maxLength,
                mergedIntervals.get(x).start - mergedIntervals.get(x - 1).finish - 1);
        }

        return Math.max(maxLength, n - mergedIntervals.get(mergedIntervals.size() - 1).finish);
    }
    private static int biggestSum(int array[]) {
        int max = 0;
        if(array!=null && array.length !=0) {
            int sum = 0;
            for (int element : array) {
                sum = ((-1 * element) < sum) ? sum + element : 0;
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2, -1, 3, 4, -1, -2, -1, 5, 4};
        System.out.println(biggestSum(array));
        System.out.println(biggestSum(null));
        System.out.println(biggestSum(new int[0]));
        Clock.systemUTC().instant().toString();

        List<Interval> intervals = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));
    }
}
