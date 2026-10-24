import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(pq.size() >= 2) {
            if(pq.peek() < K) {
                int a = pq.poll();
                int b = pq.poll();
                pq.add(a+b*2);
                ans++;
            } else {
                break;
            }
        }
        
        if(pq.size() == 1 && pq.peek() < K) {
            ans = -1;
        }
        
        return ans;
    }
}