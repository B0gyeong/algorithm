import java.util.*;
import java.io.*;

class Solution {
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    static class Node {
        int x, y, dist;
        
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = -1;
        
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new Node(0,0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.x == n-1 && curr.y == m-1) {
                answer = curr.dist+1;
                break;
            }
            
            for(int d=0; d<4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny]==0 || visited[nx][ny]) continue;
                
                q.add(new Node(nx, ny, curr.dist+1));
                visited[nx][ny] = true;
            }
        }
        
        return answer;
    }
}