import java.util.*;

public class Solution {
	static int D;
	static int W;
	static int K;
	static int minVal;
	static int [] lines;
	static int [] A;
	static int [] B;
	static int [][] matrix;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	D = sc.nextInt();
        	W = sc.nextInt();
        	K = sc.nextInt();
        	matrix = new int [D][W];
        	
        	A = new int [W];
        	B = new int [W];
        	Arrays.fill(B, 1);
        	lines = new int [D];
        	
        	for(int r=0; r<D; r++) {
        		for(int c=0; c<W; c++) {
        			matrix[r][c]= sc.nextInt(); 
        		}
        	}
        	
        	minVal = Integer.MAX_VALUE;
        	solve(0);
        	System.out.println("#"+tc+" "+minVal);
        }	
	}

	private static void solve(int k) {
		// 중복 순열
		if(k == D) {
			calculate();
			return;
		}
		
		for(int i=0; i<3; i++) {
			lines[k] = i;
			solve(k+1);
		}
	}

	private static void calculate() {
		int m = 0;
		for(int i =0; i<D; i++) {
			if(lines[i] != 0) m++;
		}
		if(m > minVal) return;
		
		int [][] copyMatrix = new int [D][W];
		for(int r=0; r<D; r++) {
    		for(int c=0; c<W; c++) {
    			copyMatrix[r][c] = matrix[r][c]; 
    		}
    	}
		
		for(int i=0; i<D; i++) {
			if(lines[i] == 2) {
				copyMatrix[i] = A;
			}
			if(lines[i] == 1) {
				copyMatrix[i] = B;
			}
			
		}
		
		boolean pass = true;
		for(int c=0; c<W; c++) {
			int maxCnt = 0;
			int cnt = 1;
    		for(int r=0; r<D-1; r++) {
    			if(copyMatrix[r][c] == copyMatrix[r+1][c]) cnt++;
    			else {
    				maxCnt = Math.max(maxCnt, cnt);
    				cnt = 1;
    			}
    		}
    		maxCnt = Math.max(maxCnt, cnt);
    		if(maxCnt < K) {
    			pass = false;
    			break;
    		}
    	}
		
		if(pass) {
			minVal = Math.min(minVal, m);
		}
		
	}
}

