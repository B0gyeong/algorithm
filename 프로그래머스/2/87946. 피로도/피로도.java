import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        
        dfs(0, k, 0, n, visited, dungeons);
        
        return answer;
    }
    
    public void dfs(int idx, int p, int cnt, int n, boolean[] visited, int[][] dungeons) {
        if(idx == n) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(dungeons[i][0] <= p) {
                    dfs(idx+1, p-dungeons[i][1], cnt+1, n, visited, dungeons);
                } else {
                    dfs(idx+1, p, cnt, n, visited, dungeons);
                }
                visited[i] = false;
            }
        }
        
    }
}