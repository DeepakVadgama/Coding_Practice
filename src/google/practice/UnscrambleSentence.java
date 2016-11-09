package google.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Scramble a sentence (including removing whitespaces)
 * Unscramble it based on dictionary.
 * <p>
 * Dictionary is pre-processed (all words in it are sorted alphabetically).
 * Otherwise the comlexity sky rockets to O(N!) just for permutations check.
 * <p>
 * Although, if dictionary is sorted, we can only return boolean (present/not)
 * and the word cannot be printed (since its not proper words, its a sorted one).
 * <p>
 * Note: Its important to know how sentence is scrambled.
 * 1. If only each word is scrambled and order of words is retained, then you only need to partition (left/right).
 * 2. If whole sentence is scrambled (not retaining word sequence) then all subsets need to be checks (subset/string-subset)
 */
public class UnscrambleSentence {

    private static Set<String> sortedDictionary = new TreeSet<>();
    private static String[] words = {"mobile", "samsung", "sam", "sung", "man", "mango",
            "icecream", "and", "go", "i", "love", "ice", "cream"};

    public static void main(String[] args) {
        sortDictionaryWords();
        String input = "i love icecream and mango";
        String scrambled = scramble(input);
        String unscrambled = unscramblePartionBased(scrambled);
        System.out.println(scrambled);
        System.out.println(unscrambled);
    }

    private static void sortDictionaryWords() {
        for (String word : words) {
            sortedDictionary.add(sorted(word));
        }
    }

    private static String sorted(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // The substring creates more memory, but code is more readable.
    // Otherwise it will require keeping track of indexes and passing in recursively
    private static String unscramblePartionBased(String scrambled) {
        for (int i = 0; i < scrambled.length(); i++) {
            String prefix = scrambled.substring(0, i + 1);
            if (isAnyPermutationValid(prefix)) {
                String suffix = unscramblePartionBased(scrambled.substring(i + 1));
                if (suffix != null) {
                    return prefix + " " + suffix;
                }
            }
        }
        return null;
    }

    // The substring creates more memory, but code is more readable.
    // Otherwise it will require keeping track of indexes and passing in recursively
    private static String unscrambleSubsetBased(String scrambled) {
        for (String word : allSubsets(scrambled)) {
            String rest = rest(scrambled, word);
            if (isAnyPermutationValid(word)) {
                String suffix = unscrambleSubsetBased(rest);
                if (suffix != null) {
                    return word + " " + suffix;
                }
            }
        }
        return null;
    }

    private static String rest(String scrambled, String word) {
        return null;
    }

    private static String[] allSubsets(String scrambled) {
        return new String[0];
    }

    // For loop of checking all permutations (complexity=O(n!)) is avoided
    // All dictionary words and prefix can be sorted and compared in 1 step
    private static boolean isAnyPermutationValid(String prefix) {
        return sortedDictionary.contains(sorted(prefix));
    }

    private static String scramble(String input) {

        input = input.replaceAll(" ", "");
        char[] arr = input.toCharArray();
        Random randomizer = new Random();

        // There are better ways to scramble, but this will do
        int n = input.length();
        for (int k = 0; k < n; k++) {
            int i = randomizer.nextInt(n);
            int j = randomizer.nextInt(n);
            swap(arr, i, j);
        }

        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
