import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num, cnt;
        
        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int compareTo(Node o) {
            if(this.cnt != o.cnt) {
                return o.cnt - this.cnt;
            }

            return o.num - this.num;
        }
    }
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        hm.forEach((key, value) -> {
            pq.add(new Node(key, value));
        });

        for(int i=0; i<K; i++) {
            System.out.print(pq.poll().num + " ");
        }
        
    }
}