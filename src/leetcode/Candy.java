package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/
 */
public class Candy {
    public static void main(String[] args) {
//        System.out.println(candy(new int[]{1, 5, 2, 10, 10, 3, 8, 9, 1, 1, 2}));
//        System.out.println(candy(new int[]{5, 3, 1}));
//        System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{1, 2, 4, 4, 3}));
    }

    public static int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }
}
