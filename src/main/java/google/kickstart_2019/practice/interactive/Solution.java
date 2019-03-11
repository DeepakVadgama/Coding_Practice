package google.kickstart_2019.practice.interactive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int start = in.nextInt();
            int end = in.nextInt();
            int tries = in.nextInt();

            for (int j = 0; j < tries; j++) {

                int mid = start + (end - start) / 2;
                System.out.print(mid);

                String result = in.next();
                if (result.equals("CORRECT")) {
                    break;
                } else if (result.equals("TOO_SMALL")) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
    }
}
