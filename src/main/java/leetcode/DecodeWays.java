package leetcode;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }

    public int numDecodings(String input) {
        return decodeWays(input, 0);
    }

    private int decodeWays(String input, int index) {

        if (index == input.length() - 1) {
            return 1;
        }

        if (doubleDigitsPossible(input, index)) {
            return 1 + decodeWays(input, index + 1);
        } else {
            return decodeWays(input, index + 1);
        }
    }

    private boolean doubleDigitsPossible(String input, int index) {
        return input.charAt(index) == '1' || (index < input.length() && input.charAt(index) == '2' && input.charAt(index + 1) <= '6');
    }
}
