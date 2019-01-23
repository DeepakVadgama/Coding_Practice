package algorithms.graphs;

import java.util.*;


/**
 * Implements algorithm to find shorted path given source vertex s
 * - Directional weighted graph. No cycles.
 * - Using Adjacency list to store graph
 * <p>
 * Input -
 * V = Number of vertexes
 * E = Number of edges
 * V1 V2 Weight = For each edge, from vertex, to vertex and weight
 * <p>
 * Sample input
 * 8
 * 13
 * 5 4 0.35
 * 4 7 0.37
 * 5 7 0.28
 * 5 1 0.32
 * 4 0 0.38
 * 0 2 0.26
 * 3 7 0.39
 * 1 3 0.29
 * 7 2 0.34
 * 6 2 0.40
 * 3 6 0.52
 * 6 0 0.58
 * 6 4 0.93
 * <p>
 * <p>
 * Answer
 * 5 to 0 (0.73)  5->4  0.35   4->0  0.38
 * 5 to 1 (0.32)  5->1  0.32
 * 5 to 2 (0.62)  5->7  0.28   7->2  0.34
 * 5 to 3 (0.61)  5->1  0.32   1->3  0.29
 * 5 to 4 (0.35)  5->4  0.35
 * 5 to 5 (0.00)
 * 5 to 6 (1.13)  5->1  0.32   1->3  0.29   3->6  0.52
 * 5 to 7 (0.28)  5->7  0.28
 */
public class DAGShortestPath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Vertices
        int v = in.nextInt();
        int e = in.nextInt();
        Graph G = new Graph(v, e);

        // Edges
        for (int i = 0; i < e; i++) {
            Edge edge = new Edge(in.nextInt(), in.nextInt(), in.nextDouble());
            G.addEdge(edge);
        }

        final AcyclicSP sp = new AcyclicSP(G);
        System.out.println(sp.distTo(0));
    }

    private static class AcyclicSP {

        private double[] distTo;
        private Edge[] edgeTo;
        private Iterable<Integer> order;

        public AcyclicSP(Graph G) {

            distTo = new double[G.V()];
            edgeTo = new Edge[G.V()];
            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;

            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            distTo[order.iterator().next()] = 0.0;

            for (int v : order) {
                for (Edge e : G.adj(v)) {
                    relax(e);
                }
            }
        }

        private void relax(Edge e) {
            int v = e.from(), w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }

        public double distTo(int v) {
            return distTo[v];
        }
    }

    private static class Graph {
        private final int V;
        private int E;
        private List<Edge>[] adj;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            adj = new List[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(Edge e) {
            adj[e.from()].add(e);
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public List<Edge> adj(int v) {
            return adj[v];
        }
    }

    private static class Edge {
        private final int v;
        private final int w;
        private final double weight;

        public Edge(int v, int w, double weight) {
            if (v < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
            if (w < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
            if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int from() {
            return v;
        }

        public int to() {
            return w;
        }

        public double weight() {
            return weight;
        }

        public String toString() {
            return v + "->" + w + " " + String.format("%5.2f", weight);
        }
    }

    private static class DepthFirstOrder {

        private boolean[] marked;          // marked[v] = has v been marked in dfs?
        private Queue<Integer> postorder;  // vertices in postorder

        public DepthFirstOrder(Graph G) {
            postorder = new LinkedList<>();
            marked = new boolean[G.V()];
            for (int v = 0; v < G.V(); v++)
                if (!marked[v]) dfs(G, v);
        }

        // run DFS in digraph G from vertex v and compute preorder/postorder
        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (Edge e : G.adj(v)) {
                if (!marked[e.to()]) {
                    dfs(G, e.to());
                }
            }
            postorder.offer(v);
        }

        public Iterable<Integer> reversePost() {
            List<Integer> list = new ArrayList<>(postorder);
            Collections.reverse(list);
            return list;
        }
    }
}
