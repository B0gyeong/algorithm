import java.util.*;

public class Solution {
    static int N;
    static double maxNum;
    static int [][] P;
    static boolean [] visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	
        	N = sc.nextInt();
        	
        	P = new int [N][N];
        	visited = new boolean [N];
        	
        	
        	for(int r=0; r<N; r++) {
        		for(int c=0; c<N; c++) {
        			P[r][c] = sc.nextInt();
        		}
        	}
        	
        	maxNum = 0;
        	
        	perm(0, 1.0);
        	
        	System.out.printf("#%d %.6f\n",tc, maxNum*100);
        }
    }
    
	private static void perm(int k, double prob) {
		if (prob <= maxNum) {
	        return;
	    }
		
		if(k == N) {
			maxNum = prob;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(k+1, prob * (P[k][i] / 100.0));
				visited[i] = false;
			} 
		}
	} 
}