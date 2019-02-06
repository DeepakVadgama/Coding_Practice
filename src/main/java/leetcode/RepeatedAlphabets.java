package leetcode;

public class RepeatedAlphabets {

    public static void main(String[] args) {

        System.out.println(new RepeatedAlphabets().strWithout3a3b(4, 6));
    }

    public static final int THRESHOLD = 3;

    public String strWithout3a3b(int A, int B) {

        int num1 = 0;
        char startChar;
        int num2 = 0;
        char secondChar;
        if (A > B) {
            num1 = A;
            startChar = 'a';
            secondChar = 'b';
        } else {
            num1 = B;
            startChar = 'b';
            secondChar = 'a';
        }

        StringBuilder result = new StringBuilder();
        while (num1 > 0 && num2 > 0) {
            num1 = appendRepeated(result, num1, startChar);
            num2 = appendRepeated(result, num2, secondChar);
        }

        appendRepeated(result, num1, ('a'));
        appendRepeated(result, num2, ('b'));

        return result.toString();
    }

    public int appendRepeated(StringBuilder result, int num1, char alphabet) {

        if (num1 >= THRESHOLD) {
            appendAlphabet(result, alphabet, THRESHOLD - 1);
            num1 -= THRESHOLD;
        } else {
            appendAlphabet(result, alphabet, num1);
            num1 = 0;
        }
        return num1;
    }

    private void appendAlphabet(StringBuilder result, char alphabet, int times) {
        for (int i = 0; i < times; i++) {
            result.append(alphabet);
        }
    }

}
