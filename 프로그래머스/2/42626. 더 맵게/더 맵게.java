import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for(int num : scoville) {
            pq.offer(num);
        }
        
        while(true) {
            if(pq.peek() < K) {
                if(pq.size() < 2) return -1;
                cnt++;
                int a = pq.poll();
                int b = pq.poll();
                int c = a + b*2;
                pq.offer(c);
            } else {
                break;
            }
        }
        
        return cnt;
    }
}