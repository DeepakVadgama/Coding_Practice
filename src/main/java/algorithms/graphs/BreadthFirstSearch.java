package algorithms.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Breadth First Search w/
 * - Unidirectional graph which may have cycles
 * - Find distances from source
 * - Using Adjacency list to store graph
 * - Using no recursion
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        LinkedList<Integer>[] adj = createGraph();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        bfs(adj, s);
    }

    private static void bfs(LinkedList<Integer>[] adj, int s) {

        boolean marked[] = new boolean[adj.length];
        int[] dist = new int[adj.length];

        marked[s] = true;
        dist[s] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer i : adj[v]) {
                if (!marked[i]) {
                    marked[i] = true;
                    dist[i] = dist[v] + 1;
                    queue.add(i);
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    private static LinkedList<Integer>[] createGraph() {
        Scanner in = new Scanner(System.in);

        // Vertices
        int v = in.nextInt();
        LinkedList<Integer>[] adj = new LinkedList[v];
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
        return adj;
    }
}
