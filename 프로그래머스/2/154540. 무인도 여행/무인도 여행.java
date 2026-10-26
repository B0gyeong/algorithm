import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) == 'X' || visited[i][j]) continue;
                
                int sum = maps[i].charAt(j) - '0';
                q.add(new int[] {i, j});
                visited[i][j] = true;
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    
                    for(int d=0; d<4; d++) {
                        int nx = curr[0] + dx[d];
                        int ny = curr[1] + dy[d];
                        
                        if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                        
                        q.add(new int[] {nx, ny});
                        sum += maps[nx].charAt(ny) - '0';
                        visited[nx][ny] = true;
                    }
                    
                }
                arr.add(sum);
            }
        }
        
        int an = arr.size();
        int[] answer = new int[an];
        for(int i=0; i<an; i++) {
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        if(answer.length == 0) {
            answer = new int[] {-1};
        }
        return answer;
    }
}