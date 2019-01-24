package algorithms.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;


/**
 * Find all paths between source and destination vertex (within max number of jumps)
 * - Directional graph which may have cycles
 * - Uses Adjacency list to store graph
 * - Uses recursion
 * <p>
 * Input
 * V = Number of vertexes
 * E = Number of edges
 * V1 V2 Weight = For each edge, from vertex, to vertex and weight
 * Steps = Maximum hops allowed
 * S D = Source and Target vertex
 * <p>
 * Sample input
 * 3 4
 * 0 2
 * 2 1
 * 1 0
 * 0 1
 * 4
 * 0 1
 */
public class AllPathsUsingDFS {

    private static List<Integer>[] adj;
    private static LinkedList<Integer> path = new LinkedList<>();
    private static int THRESHOLD;
    private static int counter;
    private static int dest;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        createGraph(in);

        // Threshold
        THRESHOLD = in.nextInt();

        // Source and Destination node
        int s = in.nextInt();
        dest = in.nextInt();

        dfs(s);
        System.out.println("Total Paths = " + counter);
    }

    private static void dfs(int i) {

        if (path.size() + 1 <= THRESHOLD) {
            path.add(i);
            for (int v : adj[i]) {
                if (v == dest) {
                    counter++;
                    print(path, v);
                }
                dfs(v);
            }
            path.removeLastOccurrence(i);
        }
    }

    private static void print(List<Integer> path, int v) {
        System.out.println(path.stream().map(String::valueOf).collect(joining(" -> ")) + " -> " + v);
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
