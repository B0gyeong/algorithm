import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    static class Node implements Comparable<Node> {
        int vertice, distance;

        Node(int vertice, int distance) {
            this.vertice = vertice;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i=1; i<=N; i++) graph.put(i, new ArrayList<>());

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st2.nextToken());
            int ev = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());

            graph.get(sv).add(new Edge(ev, w));
            graph.get(ev).add(new Edge(sv, w));
        }

        dijkstra(graph, K, N);
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source, int numVertice) {
        int [] dist = new int [numVertice+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int ver = curr.vertice;

            for(Edge e : graph.get(ver)) {
                if(curr.distance + e.weight < dist[e.target]) {
                    int val = curr.distance + e.weight;
                    dist[e.target] = val;
                    pq.add(new Node(e.target, val));
                }
            }
        }

        for(int i=1; i<=numVertice; i++) {
            System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : -1);
        }
    }
}