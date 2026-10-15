import java.util.*;

class Solution {
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            char[][] map = new char[5][5];
            
            for(int j=0; j<5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            
            answer[i] = 1;
            
            for(int x=0; x<5; x++) {
                for(int y=0; y<5; y++) {
                    if(map[x][y] == 'P') {
                        if(!bfs(map, x, y)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if(answer[i] == 0) break;
            }            
        }
        return answer;
    }
    
    static boolean bfs(char[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        q.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.dist == 2) continue;
            
            for(int d=0; d<4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                
                if(nx<0 || nx>=5 || ny<0 || ny >= 5) 
                    continue;
                if(visited[nx][ny] || maps[nx][ny] == 'X') continue;
                if(maps[nx][ny] == 'P') return false;
                
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, curr.dist+1));
            }
        }
        
        return true;
    }
}