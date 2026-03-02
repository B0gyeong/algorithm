import java.util.*;

public class Solution {	
	static int N;
	static double maxSum;
	static int [][] matrix;
	static boolean [] visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	matrix = new int [N][N];
        	for(int r=0; r<N; r++ ) {
        		for(int c=0; c<N; c++) {
        			matrix[r][c] = sc.nextInt();
        		}
        	}
        	
        	maxSum = Double.MIN_VALUE;
        	visited = new boolean [N];
        	perm(0, 1.0);
        	System.out.printf("#%d %.6f",tc, maxSum*100);
            System.out.println();
        }
	}
    
    
	private static void perm(int idx, double sum) {
		if(sum < maxSum) return;
		
		if(idx == N) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			perm(idx+1, sum * ((double) matrix[idx][i] / 100));
			visited[i] = false;
		}
	}
}