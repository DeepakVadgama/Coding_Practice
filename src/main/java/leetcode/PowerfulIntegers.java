package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public static void main(String[] args) {
//        System.out.println(new PowerfulIntegers().powerfulIntegers(2, 3, 10));
        System.out.println(new PowerfulIntegers().powerfulIntegers(1, 2, 100));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        List<Integer> powersOfX = generatePowers(x, bound - 1);
        List<Integer> powersOfY = generatePowers(y, bound - 1);

        Set<Integer> results = new HashSet<>();
        for (Integer xPower : powersOfX) {
            for (Integer yPower : powersOfY) {
                int addition = xPower + yPower;
                if (addition <= bound) {
                    results.add(addition);
                } else {
                    break;
                }
            }
        }
        return convertToList(results);
    }

    private List<Integer> convertToList(Set<Integer> set) {
        return new ArrayList<>(set);
    }

    private List<Integer> generatePowers(int number, int bound) {

        if (number == 0 || number == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            return list;
        }

        List<Integer> powers = new ArrayList<>();
        int x = 0;
        while (true) {
            int value = (int) Math.pow(number, x++);
            powers.add(value);
            if (value > bound) {
                break;
            }
        }
        return powers;
    }

}
