package hackerearth.challenge.walmartlabs;


import java.util.*;

/**
 * https://www.hackerearth.com/walmartlabs-java-developer-hiring-challenge/algorithm/ticket-counter-8/
 * If multiple optimal paths are possible, print each of the path in a separate line sorted wrt to the first node
 * <p>
 * Brain dump
 * - Directed. Weighted. Acyclic.
 * - Input is given opposite (from leaf to root)
 * - adj list: easy to find root, one with no adj value
 */
public class TicketCounter {

    private static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Vertices
        int v = in.nextInt();
        int e = in.nextInt();
        Graph graph = new Graph(v, e);

        // Edges
        for (int i = 0; i < e; i++) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;

            // Reverse direction to help ease graph operations
            Edge edge = new Edge(v2, v1, in.nextDouble());
            graph.addEdge(edge);
        }

        // Shortest 
        AcyclicSP sp = new AcyclicSP(graph);

        Iterable<Integer> leaves = sp.shortestLeaves();
        System.out.println(sp.count(graph, leaves.iterator().next()));
        for (Integer w : leaves) {
            sp.print(w);
        }
    }

    private static class AcyclicSP {

        private double[] distTo;
        private Edge[] edgeTo;
        private Edge[] edgeFrom;
        private Iterable<Integer> order;

        public AcyclicSP(Graph G) {

            distTo = new double[G.V()];
            edgeTo = new Edge[G.V()];
            edgeFrom = new Edge[G.V()];
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

        private Iterable<Integer> order() {
            return order;
        }

        private void relax(Edge e) {
            int v = e.from(), w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                edgeFrom[e.from()] = e;
            }
        }

        public double distTo(int v) {
            return distTo[v];
        }

        // There can be multiple shortest paths (ofcourse with same length) 
        public Iterable<Integer> shortestLeaves() {
            double min = Double.POSITIVE_INFINITY;
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < distTo.length; i++) {
                if (isleaf(i)) {
                    if (distTo[i] < min) {
                        min = distTo[i];
                        index.clear();
                        index.add(i);
                    } else if (distTo[i] == min) {
                        index.add(i);
                    }
                }
            }
            return index;
        }

        private boolean isleaf(int i) {
            return edgeFrom[i] == null;
        }

        public void print(int w) {

            System.out.print(w + 1);
            Edge e = edgeTo[w];
            while (e != null) {
                System.out.print(" -> " + (e.from() + 1));
                e = edgeTo[e.from()];
            }
            System.out.println();
        }

        public double count(Graph G, int w) {

            double dist = 0.0;
            Edge e = edgeTo[w];
            while (e != null) {
                dist += 2 * minEdge(G, e.from());
                e = edgeTo[e.from()];
            }
            return dist;
        }

        private double minEdge(Graph G, int w) {
            double min = Double.POSITIVE_INFINITY;
            for (Edge e : G.adj(w)) {
                if (e.weight < min) {
                    min = e.weight;
                }
            }
            return min;
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
}

