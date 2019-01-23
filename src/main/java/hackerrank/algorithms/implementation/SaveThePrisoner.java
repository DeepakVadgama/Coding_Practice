package hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/save-the-prisoner
 */
public class SaveThePrisoner {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();

            final int x = (s + m - 1) % n;
            System.out.println(x == 0 ? n : x);
        }
    }
}


//        List<String> input = Files.readAllLines(Paths.get("/home/deepak/Desktop/input00.txt"));
//        List<String> output = Files.readAllLines(Paths.get("/home/deepak/Desktop/output00.txt"));
//
//        for (int i = 0; i < input.size(); i++) {
//
//            final String[] split = input.get(i).split(" ");
//            int n = Integer.parseInt(split[0]);
//            int m = Integer.parseInt(split[1]);
//            int s = Integer.parseInt(split[2]);
//            
//            int outputVal = (s + m -1) % n ;
//            outputVal = outputVal == 0 ? n : outputVal;
//            if (outputVal != Integer.parseInt(output.get(i))) {
//                System.out.println("Problem");
//                System.out.println("Input: " + input.get(i));
//                System.out.println("Actual   Output: " + outputVal);
//                System.out.println("Expected Output: " + output.get(i));
//                System.exit(0);
//            }
//        }
