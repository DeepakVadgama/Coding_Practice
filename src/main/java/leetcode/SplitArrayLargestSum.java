package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * <p>
 * Wrong code - Doesn't work for [2,3,1,2,4,3] m=5, expected=4, actual=6
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        System.out.println(splitArray(arr, m));
    }

    public static int splitArray(int[] numbers, int m) {
        int windowSize = getWindowSize(numbers, m);
        Window[] windows = split(numbers, windowSize, m);

        for (int i = 0; i < windows.length - 1; i++) {
            Window w1 = windows[i];
            Window w2 = windows[i + 1];
            // first condition is for stupid leetcode corner case [1,2147483647]
            while (w1.sum > w2.sum && w1.sum > w2.sum + numbers[w1.j]) {
                w1.j--;
                w2.i--;
                w1.sum = w1.sum - numbers[w2.i];
                w2.sum = w2.sum + numbers[w2.i];
            }
            while (w2.sum > w1.sum && w2.sum > w1.sum + numbers[w2.i]) {
                w1.j++;
                w2.i++;
                w1.sum = w1.sum + numbers[w1.j];
                w2.sum = w2.sum - numbers[w1.j];
            }
        }

        return largestWindowSum(windows);
    }

    private static int largestWindowSum(Window[] windows) {
        int largest = 0;
        for (Window window : windows) {
            if (window.sum > largest) {
                largest = window.sum;
            }
        }
        return largest;
    }

    private static Window[] split(int[] numbers, int windowSize, int m) {
        Window[] windows = new Window[m];
        int index = 0;
        int i = 0;
        while (i < numbers.length) {
            int j = i + windowSize - 1;
            if (j >= numbers.length || index == m - 1) {
                j = numbers.length - 1;
            }
            windows[index++] = new Window(i, j, addition(numbers, i, j));
            i = j + 1;
        }
        return windows;
    }

    private static int addition(int[] numbers, int i, int j) {
        return Arrays.stream(numbers, i, j + 1).sum();
    }

    private static int getWindowSize(int[] numbers, int m) {
        int winSize = numbers.length / m;
//        if (numbers.length % m != 0) {
//            winSize++;
//        }
        return winSize;
    }

    private static class Window {
        int i, j, sum;

        public Window(int i, int j, int addition) {
            this.i = i;
            this.j = j;
            this.sum = addition;
        }
    }
}
