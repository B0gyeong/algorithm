import java.util.*;

class Solution {
    static class Node {
        int prior, ind;
        
        Node(int prior, int ind) {
            this.prior = prior;
            this.ind = ind;
        }
    }
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Node> q = new LinkedList<>();
        int n = priorities.length;
        for(int i=0; i<n; i++) {
            pq.add(priorities[i]);
            q.add(new Node(priorities[i], i));
        }
        
        int cnt = 0;
        while(!pq.isEmpty()) {
            int baseP = pq.poll();
            while(true) {
                Node temp = q.poll();
                if(temp.prior == baseP) {
                    cnt++;
                    if(temp.ind == location) {
                        return cnt;
                    } else {
                        break;
                    }
                } else {
                    q.add(temp);
                }
            }
        }
        
        return cnt;
    }
}