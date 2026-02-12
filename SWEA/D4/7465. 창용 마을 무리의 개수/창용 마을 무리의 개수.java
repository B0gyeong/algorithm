import java.util.*;

public class Solution {
	static int N;
	static int cnt;
	static int [][] matrix;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	int M = sc.nextInt();
        	matrix = new int [N+1][N+1];
        	for(int i=0; i<M; i++) {
        		int from = sc.nextInt();
        		int to = sc.nextInt();
        		matrix[from][to] = 1;
        		matrix[to][from] = 1;
        	}
        	
        	cnt = 0;
        	for(int r=1; r<=N; r++) {
        		for(int c=1; c<=N; c++) {
        			if(matrix[r][c] == 1) break;
        			if(c == N) cnt++;
        		}
        	}
        	BFS();
        	System.out.println("#"+tc+" "+cnt);
        	
        }
        
	}

	private static void BFS() {
		boolean [] visited = new boolean [N+1];
		Queue <Integer> q = new LinkedList<>();
		
		
		for(int r=0; r<=N; r++) {
    		for(int c=0; c<=N; c++) {
    			if(matrix[r][c] == 1 && !visited[r]) {
    				cnt++;
    				
    				q.add(r);
    				visited[r] = true;
    				
    				
    				while(!q.isEmpty()) {
    					int cur = q.poll();
    					
    					for(int i=0; i<=N; i++) {
    						if(matrix[cur][i]==1 && !visited[i]) {
    							q.add(i);
    							visited[i] = true;
    						}
    					}
    				}
    			}
    		}
    	}
	}
}