import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] nodes = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            if(!nodes[i]) {
                q.offer(i);
                cnt++;
            }
            
            while(!q.isEmpty()) {
                int num = q.poll();
                nodes[num] = true;
                
                for(int j=0; j<n; j++) {
                    if(j==num) continue;
                    
                    if(computers[num][j] == 1) {
                        if(!nodes[j]) q.offer(j);
                    }
                }
            }
        }
        
        return cnt;
    }
}