package hackerearth.challenge.amazon;

import java.util.*;

public class VasyaAndWork {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String food = in.next();
        String sleep = in.next();

        Map<Character, Set<Integer>> foodMap = mapFood(food);
        Map<Integer, Set<Integer>> sleepMap = mapSleep(sleep);

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(solve(food, sleep, foodMap, sleepMap, l, r));
        }
    }

    private static long solve(String food, String sleep,
                              Map<Character, Set<Integer>> foodMap,
                              Map<Integer, Set<Integer>> sleepMap,
                              int l, int r) {

        long count = 0;
        for (int i = l; i <= r; i++) {
            Character f = food.charAt(i - 1);
            Integer s = sleep.charAt(i - 1) == '0' ? 0 : 1;
            for (int j = i + 1; j <= r; j++) {
                if (foodMap.get(f).contains(j) || sleepMap.get(s).contains(j)) {
                    count = ((count + 1) % 1000000007);
                }
            }
        }
        return count;
    }

    private static Map<Integer, Set<Integer>> mapSleep(String sleep) {
        Map<Integer, Set<Integer>> sleepMap = new HashMap<>(sleep.length());
        sleepMap.put(0, new TreeSet<>());
        sleepMap.put(1, new TreeSet<>());
        for (int i = 0; i < sleep.length(); i++) {
            if (sleep.charAt(i) == '0') {
                sleepMap.get(0).add(i + 1);
            } else {
                sleepMap.get(1).add(i + 1);
            }
        }
        return sleepMap;
    }

    private static Map<Character, Set<Integer>> mapFood(String food) {
        Map<Character, Set<Integer>> foodMap = new HashMap<>(food.length());
        for (int i = 0; i < food.length(); i++) {
            foodMap.computeIfAbsent(food.charAt(i), f -> new TreeSet<>()).add(i + 1);
        }
        return foodMap;
    }
}
