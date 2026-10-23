import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            q.add(i);
            cnt++;
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int curr = q.poll();
                for(int j=0; j<n; j++) {
                    if(computers[curr][j] == 0 || visited[j]) continue;
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
        
        return cnt;
    }
}