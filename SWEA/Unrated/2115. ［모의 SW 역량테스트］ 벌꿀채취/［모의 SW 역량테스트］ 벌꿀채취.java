import java.util.*;

public class Solution {
	static int N; static int M;
	static int C;
	static int Amax; static int Bmax; static int finalMax;
	static int [][] matrix;
	static class Node {
		int r,c;
		Node(int r, int c){
			this.r = r; this.c= c;
		}
	}
	static Node [] t;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		N = sc.nextInt(); 
    		M = sc.nextInt();
    		C = sc.nextInt();
    		matrix = new int [N][N];
    		t = new Node[2];
    		for(int r=0; r<N; r++) {
    			for(int c=0; c<N; c++) {
    				matrix[r][c]= sc.nextInt();
    			}
    		}
    		
    		Amax = Integer.MIN_VALUE;
    		Bmax = Integer.MIN_VALUE;
    		finalMax = Integer.MIN_VALUE;
    		solve(0, 0);
    		System.out.println("#"+tc+" "+finalMax);
    	}
	}
    
	private static void solve(int k, int s) {
		if(k == 2) {
			calculateHoney();
		} else {
			for(int i=s; i<N*N; i++) {
				int r = i/N;
				int c = i%N;
				if(c>=N-M+1) continue;
				t[k] = new Node(r, c);
				solve(k+1, i+M);
			}
		}
		
	}

	private static void calculateHoney() {
		int [] honeyA = new int [M];
		int [] honeyB = new int [M];
		Node curr = t[0];
		int idx =0;
		for(int c=curr.c; c<curr.c+M; c++) {
			honeyA[idx] = matrix[curr.r][c];
			idx++;
		}
		curr = t[1];
		idx =0;
		for(int c=curr.c; c<curr.c+M; c++) {
			honeyB[idx] = matrix[curr.r][c];
			idx++;
		}
		
		Amax = maxHoney(honeyA, 0, 0, 0);
		Bmax = maxHoney(honeyB, 0, 0, 0);
		
		finalMax = Math.max(finalMax, Amax + Bmax);
	}

	private static int maxHoney(int[] honey, int index, int currentSum, int powSum) {
		if (currentSum > C) return 0; 

	    if (index == honey.length) {
	        return powSum; 
	    }

	    int selected = maxHoney(honey, index + 1, 
	                            currentSum + honey[index], 
	                            powSum + (honey[index] * honey[index]));

	    int notSelected = maxHoney(honey, index + 1, currentSum, powSum);
	    
	    return Math.max(selected, notSelected);
	}
}

