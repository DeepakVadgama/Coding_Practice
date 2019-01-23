package leetcode;

public class DegreeOfAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {

        CustomChar[] chars = new CustomChar[50000];

        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (chars[num] == null) {
                chars[num] = new CustomChar();
                chars[num].start = i;
            }
            chars[num].count++;
            chars[num].end = i;
            maxCount = Math.max(maxCount, chars[num].count);
        }

        int shortestDist = Integer.MAX_VALUE;
        for (int i = 0; i < 50000; i++) {
            CustomChar num = chars[i];
            if (num != null && num.count == maxCount) {
                shortestDist = Math.min(shortestDist, num.end - num.start + 1);
            }
        }
        return shortestDist;
    }

    private static class CustomChar {
        int count = 0;
        int start;
        int end;
    }
}
