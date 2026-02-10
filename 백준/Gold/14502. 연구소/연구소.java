import java.util.*;

public class Main {
	static int N; static int M;
	static int maxSum;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int [][] matrix;
	static boolean [][] visited;
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r; this.c = c;
		}
	}
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	matrix = new int [N][M]; 
    	visited = new boolean [N][M]; 
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			matrix[r][c] = sc.nextInt();
    		}
    	}
    	
    	maxSum = Integer.MIN_VALUE;
    	solve(0,0);
    	System.out.println(maxSum);

	}
    
	private static void solve(int k, int s) {
		if(k==3) {
			checkMatrix();
		} else {
			for(int i=s; i<N*M; i++) {
	    		int r = i/M;
	    		int c = i%M;
	    		if(matrix[r][c] == 0) {
	    			matrix[r][c] = 1;
	    			solve(k+1, i+1);
	    			matrix[r][c] = 0;
	    		}
	    	}
		}
		
	}

	private static void checkMatrix() {
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
		    Arrays.fill(visited[i], false);
		}
		
		for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			if(matrix[r][c]== 2 && !visited[r][c]) {
    				q.offer(new Node(r, c));
    				visited[r][c]= true; 
    				while(!q.isEmpty()) {
    					Node curr = q.poll();
    					for(int d=0; d<4; d++) {
        					int nr = curr.r + dr[d];
        					int nc = curr.c + dc[d];
        					if(0>nr||nr>=N||0>nc||nc>=M) continue;
        					if(matrix[nr][nc]!=1 && !visited[nr][nc]) {
        						q.offer(new Node(nr, nc));
        						visited[nr][nc] = true;
        					}
        				}
    				}
    				
    			}
    		}
    	}
		int cnt = 0;
		for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			if(!visited[r][c] && matrix[r][c] == 0 ) cnt++;
    		}
    	}
		if(maxSum < cnt) maxSum = cnt;
	}
}

