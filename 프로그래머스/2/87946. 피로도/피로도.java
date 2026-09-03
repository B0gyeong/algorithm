import java.util.*;

class Solution {
    static int n, answer;
    static boolean[] visited;
    static int[][] dg;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        dg = dungeons;
        visited = new boolean[n];
        answer = 0;
        dfs(0, k, 0);
        return answer;
    }
    
    public void dfs(int idx, int k, int cnt) {
        if(idx == n) {
            answer = Math.max(cnt, answer);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                System.out.print(i+" ");
                if(dg[i][0] <= k) {
                    dfs(idx+1, k-dg[i][1], cnt+1);
                } else {
                    dfs(idx+1, k, cnt);
                }
                visited[i] = false;
            }
        }
    }
}