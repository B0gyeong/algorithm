import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;

        Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i <= N; i++) graph.put(i, new ArrayList<>());

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int sv = Integer.parseInt(st2.nextToken());
            int ev = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            
            graph.get(sv).add(new Edge(ev, w));
        }

        dijkstra(graph, 1, N);

        
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source, int numVertices) {
        int [] dist = new int [numVertices+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if(current.distance > dist[u]) continue;

            if(graph.containsKey(u)) {
                for(Edge e : graph.get(u)) {
                    int v = e.target;
                    int alt = dist[u] + e.weight;

                    if(alt < dist[v]) {
                        dist[v] = alt;
                        pq.add(new Node(v, alt));
                    }
                }
            }
        }

        for(int i=2; i<=N; i++) {
            System.out.println(dist[i]!=Integer.MAX_VALUE ? dist[i] : -1);
        }
    }
}