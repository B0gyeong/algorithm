import java.util.*;
public class Solution {
	public static int N;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	public static int[][] memo;
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		N = sc.nextInt();
    		int [][] matrix = new int [N][N];
    		memo = new int[N][N];
    		
    		for(int r=0; r<N; r++) {
    			for(int c=0; c<N; c++) {
    				matrix[r][c] = sc.nextInt();
    			}
    		}
    		
    		int bestRoomCnt = 0;
    		int bestRoomNum = 0;
    		
    		for(int r=0; r<N; r++) {
    			for(int c=0; c<N; c++) {
    				int cnt = dfs(r,c, matrix);
    				if(cnt > bestRoomCnt) {
    					bestRoomCnt = cnt;
    					bestRoomNum = matrix[r][c];
    				} else if(cnt == bestRoomCnt) {
    					bestRoomNum = Math.min(bestRoomNum, matrix[r][c]);
    				}
    			}
    		}
    		System.out.println("#"+tc+" "+bestRoomNum+" "+bestRoomCnt);
    	}
    }

	private static int dfs(int r, int c, int[][] matrix) {
		if (memo[r][c] != 0) return memo[r][c];
		
		memo[r][c] = 1;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isWall(nr,nc)&& matrix[nr][nc] == matrix[r][c]+1) {
				memo[r][c] = Math.max(memo[r][c], dfs(nr,nc,matrix)+1);
			}
		}
		return memo[r][c];
	}

	private static boolean isWall(int r, int c) {
		return r<0 || r>= N || c<0 || c>= N;
	}
}
