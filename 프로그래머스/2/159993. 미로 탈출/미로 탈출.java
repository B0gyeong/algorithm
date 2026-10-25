import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[][] map;
    int sx, sy, lx, ly, ex, ey, n, m, answer1, answer2;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        sx = 0; sy = 0;
        lx = 0; ly = 0;
        ex = 0; ey = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'S') {
                    sx = i; sy = j;
                } else if (map[i][j] == 'L') {
                    lx = i; ly = j;
                } else if (map[i][j] == 'E'){
                    ex = i; ey = j;
                }
            }
        }
        
        answer1 = -1;
        answer2 = -1;
        visited = new boolean[n][m];
        
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        bfs(lx, ly, 1);
        if(answer1 == -1) return -1;
        
        q.clear();
        q.add(new int[] {lx, ly, 0});
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = false;
            }
        }
        visited[lx][ly] = true;
        bfs(ex, ey, 2);
        if(answer2 == -1) return -1;
        return answer1 + answer2;
    }
    
    public void bfs(int tx, int ty, int type) {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(temp[0]==tx && temp[1]==ty) {
                if(type == 1) {
                    if(answer1 == -1) answer1 = temp[2];
                    else answer1 = Math.min(answer1, temp[2]);
                } else {
                    if(answer2 == -1) answer2 = temp[2];
                    else answer2 = Math.min(answer2, temp[2]);
                }
                return;
            }
            
            for(int d=0; d<4; d++) {
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visited[nx][ny] || map[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, temp[2]+1});
            }
        }
        return;
    }
}