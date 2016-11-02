package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-division/
 * <p>
 * DFS
 */
public class EvaluateDivision {

    public static void main(String[] args) {

//        String[][] equations = {{"a", "b"}, {"b", "c"}};
//        double[] values = {2.0, 3.0};
//        String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
//
        String[][] equations = {{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}};
        double[] values = {3.0, 4.0, 5.0, 6.0};
        String[][] queries = {{"x5", "x2"}};
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(String[][] rawEquations, double[] values, String[][] queries) {

        double[] results = new double[queries.length];

        Map<String, Map<String, Double>> equations = initEquations(rawEquations, values);
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String from = query[0];
            String to = query[1];
            if (!isValid(equations, from, to)) {
                results[i] = -1.0;
            } else {
                results[i] = calc(equations, new HashSet<>(), from, to);
            }
        }
        return results;
    }

    private static double calc(Map<String, Map<String, Double>> equations,
                               HashSet<String> visited,
                               String from,
                               String to) {

        if (from.equals(to)) {
            return 1;
        }

        if (!equations.containsKey(from) || visited.contains(from)) {
            return -1;
        }

        visited.add(from);
        for (Map.Entry<String, Double> entry : equations.get(from).entrySet()) {
            double currResult = entry.getValue() * calc(equations, visited, entry.getKey(), to);
            if (currResult > 0) {
                return currResult;
            }
        }
        return -1;
    }

    private static boolean isValid(Map<String, Map<String, Double>> equations, String from, String to) {
        return equations.containsKey(from) && equations.containsKey(to);
    }

    private static Map<String, Map<String, Double>> initEquations(String[][] rawEquations, double[] values) {
        Map<String, Map<String, Double>> equations = new HashMap<>();
        for (int i = 0; i < rawEquations.length; i++) {
            String from = rawEquations[i][0];
            String to = rawEquations[i][1];
            equations.computeIfAbsent(from, key -> new HashMap()).put(to, values[i]);
            equations.computeIfAbsent(to, key -> new HashMap()).put(from, 1 / values[i]);
        }
        return equations;
    }
}
