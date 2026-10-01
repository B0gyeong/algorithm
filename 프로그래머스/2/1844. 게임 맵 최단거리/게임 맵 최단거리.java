import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = { 0, 0, -1, 1};
    
    static class Node {
        int x, y, d;
        
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int cx = curr.x;
            int cy = curr.y;
            
            for(int d=0; d<4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d]; 
                
                if((nx<0 || nx>=n || ny<0 || ny>=m) || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                if(nx == n-1 && ny == m-1) return curr.d + 2;
                
                q.offer(new Node(nx, ny, curr.d+1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}