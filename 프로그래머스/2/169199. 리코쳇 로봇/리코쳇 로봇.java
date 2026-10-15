import java.util.*;

class Solution {
    static class Node {
        int x, y, dist;
        
        Node(int x, int y, int dist){
            this.x = x; 
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int xl, yl;
    
    public int solution(String[] board) {
        int answer = 0;
        xl = board.length;
        yl = board[0].length();
        char[][] maps = new char[xl][yl];
        for(int i=0; i<xl; i++) {
            maps[i] = board[i].toCharArray();
        }
        
        for(int x=0; x<xl; x++) {
            for(int y=0; y<yl; y++) {
                if(maps[x][y] == 'R') {
                    answer = bfs(maps, x, y);
                }
            }
        }
        
        return answer;
    }
    
    static int bfs(char[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[xl][yl];
        
        q.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
    
            for(int d=0; d<4; d++) {
                int cx = curr.x;
                int cy = curr.y;
                while(true) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if(nx<0 || nx>=xl || ny<0 || ny>=yl || maps[nx][ny] == 'D') {
                        if(maps[cx][cy] == 'G') {
                            return curr.dist+1;
                        } else {
                            if (!visited[cx][cy]) {
                                q.add(new Node(cx, cy, curr.dist+1));
                                visited[cx][cy] = true;
                            }
                            break;
                        }
                    }
                    else {
                        cx = nx; cy = ny;
                    }
                }
                
            }
        }
        
        return -1;
    }
}