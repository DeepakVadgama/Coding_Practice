package algorithms.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Depth First Search w/
 * - Unidirectional graph which may have cycles
 * - Find distances from source
 * - Using Adjacency list to store graph
 * - Using recursion
 */
public class DepthFirstSearch {

    private static LinkedList<Integer>[] adj;
    private static boolean[] marked;
    private static int[] dist;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        createGraph(in);

        int s = in.nextInt();
        marked = new boolean[adj.length];
        dist = new int[adj.length];

        marked[s] = true;
        dist[s] = 0;

        dfs(s);
        System.out.println(Arrays.toString(dist));
    }

    private static void dfs(int i) {
        for (int v : adj[i]) {
            if (!marked[v]) {
                marked[v] = true;
                dist[v] = dist[i] + 1;
                dfs(v);
            }
        }
    }

    private static void createGraph(Scanner in) {
        // Vertices
        int v = in.nextInt();
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

        // Edges
        int e = in.nextInt();
        for (int i = 0; i < e; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            adj[v1].add(v2);
        }
    }

}
