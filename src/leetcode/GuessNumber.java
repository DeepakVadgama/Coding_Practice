package leetcode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumber {

    private int number;

    public GuessNumber(int num) {
        this.number = num;
    }

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(2);
        System.out.println(game.guessNumber(2));
    }

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                low = mid + 1;
            } else if (res == -1) {
                high = mid;
            }
        }
        return low;
    }

    private int guess(int i) {
        if (i == number) {
            return 0;
        } else if (i > number) {
            return -1;
        } else {
            return 1;
        }
    }
}
