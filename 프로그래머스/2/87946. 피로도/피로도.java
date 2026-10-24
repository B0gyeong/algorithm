import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        
        dfs(k, 0, visited, dungeons);
        
        return answer;
    }
    
    public void dfs(int p, int cnt, boolean[] visited, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        
        int n = visited.length;
        for(int i=0; i<n; i++) {
            if(!visited[i] && dungeons[i][0] <= p) {
                visited[i] = true;
                dfs(p-dungeons[i][1], cnt+1, visited, dungeons);
                visited[i] = false;
            }
        }
        
    }
}