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
        int A = Integer.parseInt(st3.nextToken());
        int B = Integer.parseInt(st3.nextToken());

        dijkstraPath(graph, A, B, N);
    }

    public static void dijkstraPath(Map<Integer, List<Edge>> graph, int start, int dest, int N) {
        int [] dist = new int [N+1];
        int [] parent = new int [N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int ver = curr.vertice;

            if(curr.distance > dist[ver]) continue;
            if(ver == dest) break;
            
            for(Edge e : graph.get(ver)) {
                if(curr.distance + e.weight < dist[e.target]) {
                    dist[e.target] = curr.distance + e.weight;

                    parent[e.target] = ver;

                    pq.add(new Node(e.target, dist[e.target]));
                }
            }
        }

        Stack<Integer> pathStack = new Stack<>();
        int curr = dest;

        while(curr != 0) {
            pathStack.push(curr);
            if(curr == start) break;
            curr = parent[curr];
        }

        System.out.println(dist[dest]);
        while(!pathStack.isEmpty()) {
            System.out.print(pathStack.pop() + " ");
        }

    }
}