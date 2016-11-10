package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    private final int[] nums;

    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray(new int[]{2, 4, 6, 8, 10});
        System.out.println(Arrays.toString(shuffleArray.reset()));
        System.out.println(Arrays.toString(shuffleArray.shuffle()));
        System.out.println(Arrays.toString(shuffleArray.reset()));
        System.out.println(Arrays.toString(shuffleArray.shuffle()));
    }

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        int n = nums.length;
        Random random = new Random();

        int[] shuffled = Arrays.copyOf(nums, n);
        for (int i = 0; i < shuffled.length - 1; i++) {
            int j = randomBetween(random, i + 1, n - 1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }

    private int randomBetween(Random random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
