import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int num, idx;
        
        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }
    
    public int[] solution(String[] operations) {
        int[] answer = {};
        int n = operations.length;
        PriorityQueue<Node> lpq = new PriorityQueue<>();
        PriorityQueue<Node> hpq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[n];
        int size = 0;
        for(int i=0; i<n; i++) {
            String s = operations[i];
            int num = Integer.parseInt(s.substring(2));
            
            if(s.charAt(0) == 'I') {
                lpq.add(new Node(num, i));
                hpq.add(new Node(num, i));
                size++;
            } else {
                if(size == 0) continue;
                if(num == -1) {
                    while(visited[lpq.peek().idx]) {
                        lpq.poll();
                    }
                    Node curr = lpq.poll();
                    size--;
                    visited[curr.idx] = true;
                } else {
                    while(visited[hpq.peek().idx]) {
                        hpq.poll();
                    }
                    Node curr = hpq.poll();
                    size--;
                    visited[curr.idx] = true;
                }
            }
        }
        
        if(size==0) return new int[]{0, 0};
        while(visited[lpq.peek().idx]) {
            lpq.poll();
        }
        Node ln = lpq.poll();
        int minV = ln.num;
        while(visited[hpq.peek().idx]) {
            hpq.poll();
        }
        Node hn = hpq.poll();
        int maxV = hn.num;
        return new int[]{maxV, minV};
    }
}