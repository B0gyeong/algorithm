import java.util.*;

public class Solution {
	static int N;
	static int M;
	static int L;
	static int [] dr = { -1, 1, 0, 0};
	static int [] dc = { 0, 0, -1, 1};
	static int [][] matrix;
	static int [][] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt(); 
        	M = sc.nextInt();
        	int R = sc.nextInt();
        	int C = sc.nextInt();
        	L = sc.nextInt();
        	
        	matrix = new int [N][M];
        	visited = new int [N][M];
        	
        	for(int r=0; r<N; r++) {
        		for(int c=0; c<M; c++) {
        			matrix[r][c] = sc.nextInt(); 
        		}
        	}
        	
        	visited[R][C] = 1;
        	solve(1, R, C, 4);
        	
        	int cnt = 0;
        	for(int r=0; r<N; r++) {
        		for(int c=0; c<M; c++) {
        			if(visited[r][c]>0) cnt++; 
        		}
        	}
        	System.out.println("#"+tc+" "+cnt);
        }	
	}
    
	private static void solve(int t, int r, int c, int from) {
		if(r<0||r>=N||c<0||c>=M ) return;

		int state = matrix[r][c];
		
		if(!checkValid(state, from)) return;
		if(visited[r][c]>0) {
			if(visited[r][c] < t) return;
		}
		
		if(t == L+1) {
			return;
		} 
		
		visited[r][c]= t; 
		
		switch (state) {
		case 1:
			for(int d=0; d<4; d++) {
				solve(t+1, r+dr[d], c+dc[d], d);
			}
			break;
		case 2:
			for(int d=0; d<2; d++) {
				solve(t+1, r+dr[d], c+dc[d], d);
			}
			break;
		case 3:
			for(int d=2; d<4; d++) {
				solve(t+1, r+dr[d], c+dc[d], d);
			}
			break;
		case 4:
			solve(t+1, r+dr[0], c+dc[0], 0);
			solve(t+1, r+dr[3], c+dc[3], 3);
			break;
		case 5:
			for(int d=1; d<4; d+=2) {
				solve(t+1, r+dr[d], c+dc[d], d);
			}
			break;
		case 6:
			solve(t+1, r+dr[1], c+dc[1], 1);
			solve(t+1, r+dr[2], c+dc[2], 2);
			break;
		case 7:
			for(int d=0; d<4; d+=2) {
				solve(t+1, r+dr[d], c+dc[d], d);
			}
			break;
		}
		
		
	}

	private static boolean checkValid(int state, int from) {
	    switch (from) {
	        case 0:
	            return state == 1 || state == 2 || state == 5 || state == 6;
	        case 1:
	            return state == 1 || state == 2 || state == 4 || state == 7;
	        case 2:
	            return state == 1 || state == 3 || state == 4 || state == 5;
	        case 3:
	            return state == 1 || state == 3 || state == 6 || state == 7;
	        default:
	            return true;
	    }
	}
}

