package leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        HashMap<Integer, Integer> products = new HashMap<>();
        products.put(1, 1);
        products.put(2, 1);
        products.put(3, 2);
        if (n == 3 || n == 2) {
            return products.get(n);
        }
        return memoizedIntegerProduct(n, products);
    }


    private static int memoizedIntegerProduct(int n, HashMap<Integer, Integer> products) {

        if (products.containsKey(n)) {
            return Math.max(products.get(n), n);
        }

        int maxProduct = 0;
        for (int i = 2; i < n; i++) {
            int product = i * memoizedIntegerProduct(n - i, products);
            maxProduct = product > maxProduct ? product : maxProduct;
        }
        products.put(n, maxProduct);
        return maxProduct;
    }
}
