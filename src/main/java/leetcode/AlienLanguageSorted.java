package leetcode;


/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary
 */
public class AlienLanguageSorted {

    public boolean isAlienSorted(String[] words, String order) {

        int[] idxOrder = convertToIdxArray(order);
        for (int i = 0; i < words.length - 1; i++) {
            if (!isLexicographicallyValid(words[i], words[i + 1], idxOrder)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLexicographicallyValid(String leftWord, String rightWord, int[] idxOrder) {

        int i = 0, j = 0;
        for (; i < leftWord.length() && j < rightWord.length(); i++, j++) {
            char leftChar = leftWord.charAt(i);
            char rightChar = rightWord.charAt(j);

            if (idxOrder[leftChar - 'a'] > idxOrder[rightChar - 'a']) {
                return false;
            } else if (idxOrder[leftChar - 'a'] < idxOrder[rightChar - 'a']) {
                return true;
            }
        }

        if (i < leftWord.length()) {
            return false;
        }
        return true;
    }

    public int[] convertToIdxArray(String order) {
        int[] idxOrder = new int[26];
        for (int i = 0; i < 26; i++) {
            idxOrder[order.charAt(i) - 'a'] = i;
        }
        return idxOrder;
    }
}
