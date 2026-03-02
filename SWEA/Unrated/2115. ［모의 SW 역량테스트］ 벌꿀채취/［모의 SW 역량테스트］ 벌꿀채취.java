import java.util.*;

public class Solution {	
	static int N, M, C, miniSum, maxAns;
	static int [] selected;
	static int [][] matrix;
	static int [] arr;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	C = sc.nextInt();
        	matrix = new int [N][N];
        	
        	for(int r=0; r<N; r++) {
        		for(int c=0; c<N; c++) {
        			matrix[r][c] = sc.nextInt();
        		}
        	}
        	
        	arr = new int [N*N];
        	for(int i=0; i<N*N-M+1; i++) {
        		int r = i / N;
        		int c = i % N;
        		
        		if(c+M > N) arr[i] = 0;
        		else {
        			miniSum = 0;
        			subset(i, 0, 0, i+M);
        			arr[i] = miniSum;
        		}
         	}
        	
        	selected = new int [2];
        	maxAns = 0;
        	comb(0, 0);
        	System.out.println("#"+tc+" "+maxAns);
        	
        }
        
	}
    
	private static void subset(int idx, int sum, int powSum, int F) {
		if(sum > C) return;
		
		if(idx == F) {
			miniSum = Math.max(miniSum, powSum);
			return;
		}
			
		int r = idx / N;
		int c = idx % N;

		subset(idx+1, sum, powSum, F);
		subset(idx+1, sum+matrix[r][c], powSum + matrix[r][c]*matrix[r][c], F);
	}

	private static void comb(int idx, int start) {
		if(idx == 2) {
			if(check(selected[0], selected[1])) {
				maxAns = Math.max(maxAns, arr[selected[0]] + arr[selected[1]]);
			}
			
			return;
		}
		
		for(int i=start; i<N*N; i++) {
			selected[idx] = i;
			comb(idx+1, i+1);
		}
		
	}

	private static boolean check(int a, int b) {
		int nr1 = a / N; int nc1 = a % N;
		int nr2 = b / N; int nc2 = b % N;
		
		if(nr1 != nr2) return true;
		
		return nc1 + M <= nc2;
	}
}