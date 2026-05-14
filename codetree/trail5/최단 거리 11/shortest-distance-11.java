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

        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st3.nextToken());
        int dest = Integer.parseInt(st3.nextToken());

        int [] dist = getDijkstra(graph, dest, N);

        findPath(graph, dist, start, dest, N);
    }

    public static int [] getDijkstra(Map<Integer, List<Edge>> graph, int start, int N) {
        int [] dist = new int [N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int ver = curr.vertice;

            if(dist[ver] < curr.distance) continue;

            for(Edge e : graph.get(ver)) {
                if(dist[ver] + e.weight < dist[e.target]) {
                    dist[e.target] = dist[ver] + e.weight;
                    pq.add(new Node(e.target, dist[e.target]));
                }
            }
        }

        return dist;

    }
    public static void findPath(Map<Integer, List<Edge>> graph, int [] dist, int start, int dest, int N){
        System.out.println(dist[start]);
        int x = start;
        System.out.print(x + " ");

        while(x != dest) {
            for(int i=1; i<=N; i++){
                int weight = -1;
                for(Edge e : graph.get(x)) {
                    if(e.target == i) {
                        weight = e.weight;
                        break;
                    }
                }

                if(weight != -1 && dist[i] + weight == dist[x]) {
                    x = i;
                    System.out.print(x + " ");
                    break;
                }
            }
        }
    }
}