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
public class DFS_ConnectedComponent {

    private static LinkedList<Integer>[] adj;
    private static boolean[] marked;
    private static int count;
    private static int[] size;
    private static int[] id;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int v = createGraph(in);

        marked = new boolean[adj.length];
        size = new int[adj.length];
        id = new int[adj.length];

        for (int i = 0; i < v; i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
        System.out.println(Arrays.toString(size));
        System.out.println(Arrays.toString(id));
    }

    private static void dfs(int i) {

        marked[i] = true;
        size[count]++;
        id[i] = count;

        for (int v : adj[i]) {
            if (!marked[v]) {
                dfs(v);
            }
        }
    }

    private static int createGraph(Scanner in) {
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
        return v;
    }
}
