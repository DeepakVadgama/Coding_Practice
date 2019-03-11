package google.practice;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public static void main(String[] args) {
//        System.out.println(isSubsequence("abc", "ahbgdc"));
//        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(followUp("abc", "ahbgdc"));
        System.out.println(followUp("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int ti = 0, si = 0;
        while (ti < t.length() && si < s.length()) {
            if (t.charAt(ti) == s.charAt(si)) {
                si++;
            }
            ti++;
        }
        return si == s.length();
    }

    // What is there are n number of strings s to check
    // Solution: pre-process t, store all indexes of each char
    public static boolean followUp(String s, String t) {
        TreeSet<Integer>[] indexes = getIndexes(t);
        int sIndex = 0;
        int cIndex = -1;
        while (sIndex < s.length()) {
            char ch = s.charAt(sIndex);
            Integer index = indexOf(indexes, ch, cIndex);
            if (index == null) {
                break;
            }
            cIndex = index;
            sIndex++;
        }
        return sIndex == s.length();
    }

    private static Integer indexOf(TreeSet<Integer>[] indexes, char ch, int cIndex) {
        return indexes[ch - 'a'].higher(cIndex);
    }

    private static TreeSet<Integer>[] getIndexes(String t) {
        TreeSet<Integer>[] indexes = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            indexes[i] = new TreeSet<>();
        }
        for (int i = 0; i < t.length(); i++) {
            indexes[t.charAt(i) - 'a'].add(i);
        }
        return indexes;
    }


}
