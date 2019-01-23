package leetcode;


/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStringNumbers {
    public static void main(String[] args) {
        System.out.println(addStrings("345", "92346"));
    }

    public static String addStrings(String num1, String num2) {

        String result = "";

        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int digit1 = getDigit(num1, i);
            int digit2 = getDigit(num2, j);
            int addition = digit1 + digit2 + carry;
            result = addition % 10 + result;
            carry = addition / 10;
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }

    private static int getDigit(String string, int i) {
        return i < string.length() && i >= 0 ? Integer.parseInt(string.substring(i, i + 1)) : 0;
    }

}
