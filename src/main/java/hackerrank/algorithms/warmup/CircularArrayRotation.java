package hackerrank.algorithms.warmup;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/circular-array-rotation
 */
public class CircularArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        // create list
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // shift by k
        for (int i = 0; i < k; i++) {
            list.addFirst(list.pollLast());
        }

        // get queries
        int queries[] = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }

        // answer queries
        for (int i = 0; i < q; i++) {
            System.out.println(list.get(queries[i]));
        }
    }
}