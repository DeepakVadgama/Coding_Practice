package leetcode;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            counts[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
