import java.util.*;
import java.io.*;

class Solution {
    static class Node {
        int x, y, dist;
        
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.x == n-1 && curr.y == m-1) {
                return curr.dist;
            }
            
            for(int d=0; d<4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                if(maps[nx][ny]==1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny,curr.dist+1));
                }
            }
        }
        
        return -1;
    }
}