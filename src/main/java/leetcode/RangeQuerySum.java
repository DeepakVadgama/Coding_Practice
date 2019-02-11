package leetcode;

public class RangeQuerySum {

    public static void main(String[] args) {

        RangeQuerySum obj = new RangeQuerySum(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

    int[] sum = new int[0];

    public RangeQuerySum(int[] nums) {
        if (nums != null) {
            sum = createSumArray(nums);
        }
    }

    private int[] createSumArray(int[] nums) {
        int[] sum = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum[i] = count;
        }
        return sum;
    }

    public int sumRange(int i, int j) {

        if (i < 0) {
            i = 0;
        }

        if (j >= sum.length) {
            j = sum.length - 1;
        }

        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}
