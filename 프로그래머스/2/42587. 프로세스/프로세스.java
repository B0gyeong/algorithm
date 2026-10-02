import java.util.*;

class Solution {
    static class Node {
        int priority, index;
        
        Node(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = priorities.length;
        for(int i=0; i<n; i++) {
            q.offer(new Node(priorities[i], i));
            pq.offer(priorities[i]);
        }
        
        int cnt=0;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.priority < pq.peek()) {
                q.offer(curr);
            } else {
                pq.poll();
                cnt++;
                if(curr.index == location) return cnt;
            }
        }
        
        int answer = 0;
        return answer;
    }
}