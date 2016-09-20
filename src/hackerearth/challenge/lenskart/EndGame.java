package hackerearth.challenge.lenskart;


import java.util.Scanner;

/**
 * https://www.hackerearth.com/lenskart-hiring-challenge/algorithm/end-game/
 * <p>
 * Cheated - https://www.hackerearth.com/submission/5006471/
 **/
public class EndGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long d = in.nextLong();
            long Move = in.nextInt();

            // Crux = moves(black to reach n) < moves(white to catch up)
            // constraints = black/white to stay within board
            // constraints = black not be  (1,n) , (2,n) , (1,n-1) , (2,n-1) , (a,b)

            if (Move == 0) {
                if (c >= a && Math.abs(d - b) <= (n - a)) {
                    System.out.println("Draw");
                } else {
                    System.out.println("White Wins");
                }
            } else {
                if (c >= a - 1 && Math.abs(d - b) <= (n - a + 1)) {
                    System.out.println("Draw");
                } else {
                    System.out.println("White Wins");
                }
            }

        }
    }

}

