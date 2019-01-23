package leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * <p>
 * Not working in leetcode env due to interpretation of \t and \n
 */
public class LongestAbsolutePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileSystem = in.next();
        System.out.println(lengthLongestPath(fileSystem));
    }

    public static int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        HashMap<Integer, Integer> levels = new HashMap<>();
        int maxLength = 0;
        for (String subpath : input.split("\\\\n")) {
            int depth = getDepth(subpath);
            int nameLength = name(subpath).length();
            if (!isFile(subpath)) {
                levels.put(depth, nameLength + 1);
            } else {
                int length = lengthUntil(levels, depth) + nameLength;
                maxLength = length > maxLength ? length : maxLength;
            }
        }
        return maxLength;
    }

    private static int lengthUntil(HashMap<Integer, Integer> levels, int pathDepth) {
        int count = 0;
        for (int i = 0; i < pathDepth; i++) {
            count += levels.get(i);
        }
        return count;
    }

    private static boolean isFile(String subpath) {
        return subpath.endsWith(".ext");
    }

    private static String name(String subpath) {
        return subpath.replaceAll("\\\\t", "");
    }

    private static int getDepth(String subpath) {
        int count = 0, i = 0;
        while (i < subpath.length() - 1) {
            if (subpath.charAt(i) == '\\' && subpath.charAt(i + 1) == 't') {
                count++;
            }
            i++;
        }
        return count;
    }
}
