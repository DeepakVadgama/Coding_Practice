package leetcode;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
//        obj.isPalindrome("A man, a plan, a canal: Panama");
        obj.isPalindrome("1b1");
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        s = s.toLowerCase();

        int start = incrementToValidChar(s, 0);
        int end = decrementToValidChar(s, s.length() - 1);

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }


            start = incrementToValidChar(s, start + 1);
            end = decrementToValidChar(s, end - 1);
        }

        return true;
    }

    public int incrementToValidChar(String s, int index) {
        while (index < s.length() && !isValidLetter(s.charAt(index))) {
            index++;
        }
        return index;
    }

    public int decrementToValidChar(String s, int index) {
        while (index >= 0 && !isValidLetter(s.charAt(index))) {
            index--;
        }
        return index;
    }

    public boolean isValidLetter(Character c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

}
