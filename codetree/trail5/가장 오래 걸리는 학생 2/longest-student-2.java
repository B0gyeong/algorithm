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

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i=0; i<=N; i++) graph.put(i, new ArrayList<>());

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());

            graph.get(j).add(new Edge(sv, d));
        }

        dijkstra(graph, N, N);
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source, int N) {
        int [] dist = new int [N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int ver = curr.vertice;
            
            for(Edge e : graph.get(ver)){
                if(curr.distance + e.weight < dist[e.target]) {
                    pq.add(new Node(e.target, curr.distance + e.weight));
                    dist[e.target] = curr.distance + e.weight;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=1; i<N; i++) {
            if(dist[i] > result) result = dist[i];
        }
        System.out.println(result);
    }
}