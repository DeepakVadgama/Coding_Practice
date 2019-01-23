package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * Implements Dijkstra's algorithm to find shorted path given source vertex S
 * - Directional weighted graph. May contain cycles. Non negative weights.
 * - Using Adjacency list to store graph
 * <p>
 * Input -
 * V = Number of vertexes
 * E = Number of edges
 * V1 V2 Weight = For each edge, from vertex, to vertex and weight
 * S = Source Vertex
 */
public class DijkstraShortestPath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Vertices
        int v = in.nextInt();
        int e = in.nextInt();
        Graph graph = new Graph(v, e);

        // Edges
        for (int i = 0; i < e; i++) {
            Edge edge = new Edge(in.nextInt(), in.nextInt(), in.nextDouble());
            graph.addEdge(edge);
        }

        int s = in.nextInt();
        final DijkstraSP sp = new DijkstraSP(graph, s);
        System.out.println(sp.distTo(5));
    }

    private static class DijkstraSP {

        private double[] distTo;
        private Edge[] edgeTo;
        TreeSet<EdgeDist> pq = new TreeSet<>();

        public DijkstraSP(Graph graph, int s) {
            distTo = new double[graph.V()];
            edgeTo = new Edge[graph.V()];
            for (int i = 0; i < graph.V(); i++) {
                distTo[i] = Integer.MAX_VALUE;
            }
            distTo[s] = 0.0;

            pq.add(new EdgeDist(s, distTo[s]));
            while (!pq.isEmpty()) {
                final EdgeDist ed = pq.pollFirst();
                int v = ed.v();
                for (Edge e : graph.adj(v)) {
                    relax(e);
                }
            }
        }

        private void relax(Edge e) {
            int v = e.from(), w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                EdgeDist ed = new EdgeDist(w, distTo[w]);
                pq.remove(ed);
                pq.add(ed);
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

    private static class EdgeDist implements Comparable {

        private double dist;
        private int v;

        public EdgeDist(int v, double dist) {
            this.dist = dist;
            this.v = v;
        }

        public double dist() {
            return dist;
        }

        public int v() {
            return v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EdgeDist edgeDist = (EdgeDist) o;
            return v == edgeDist.v;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(dist);
            result = (int) (temp ^ (temp >>> 32));
            result = 31 * result + v;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            EdgeDist edgeDist = (EdgeDist) o;
            return (int) (dist - edgeDist.dist);
        }
    }
}
