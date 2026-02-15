import java.util.*;

public class Main {
	static int N;
	static int M;
	static int K;
	static int minSum;
	static int [] t;
	static boolean [] visited;
	static int [][] rotate;
	static int [][] matrix;
	static int [][] copyMatrix;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	K = sc.nextInt();
    	
    	matrix = new int[N+1][M+1];
    	copyMatrix = new int[N+1][M+1];
    	for(int r=1; r<N+1; r++) {
    		for(int c=1; c<M+1; c++) {
        		matrix[r][c] = sc.nextInt();
        	}
    	}
    	
    	rotate = new int [K][3];
    	visited = new boolean [K];
    	t = new int [K];
    	for(int i=0; i<K; i++) {
    		rotate[i][0] = sc.nextInt();
    		rotate[i][1] = sc.nextInt();
    		rotate[i][2] = sc.nextInt();
    	}
    	
    	minSum = Integer.MAX_VALUE;
    	solve(0);
    	System.out.println(minSum);

    }

	private static void solve(int idx) {
		if(idx == K) {
			for(int r=1; r<N+1; r++) {
	    		for(int c=1; c<M+1; c++) {
	        		copyMatrix[r][c] = matrix[r][c];
	        	}
	    	}
			for(int i=0; i<K; i++) {
				calculate(rotate[t[i]][0], rotate[t[i]][1], rotate[t[i]][2]);
			}
			int sum = calSum();
			minSum = Math.min(minSum, sum);
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				t[idx] = i;
				solve(idx+1);
				visited[i] = false;
			}
		}
	}

	private static int calSum() {
		int rowSum = Integer.MAX_VALUE;
		for(int r=1; r<=N; r++) {
			int sum = 0;
			for(int c=1; c<=M; c++) {
				sum += copyMatrix[r][c];
			}
			rowSum = Math.min(rowSum, sum);
		}
		return rowSum;
	}

	private static void calculate(int r, int c, int s) {
		for(int i=0; i<s; i++) {
			int startR = r-s+i;
			int startC = c-s+i;
			int endR = r+s-i;
			int endC = c+s-i;
			
			int temp = copyMatrix[startR][startC];
			for(int ir=startR; ir<endR; ir++) {
				copyMatrix[ir][startC] = copyMatrix[ir+1][startC];
			}
			for(int ic=startC; ic<endC; ic++) {
				copyMatrix[endR][ic] = copyMatrix[endR][ic+1];
			}
			for(int ir=endR; ir>startR; ir--) {
				copyMatrix[ir][endC] = copyMatrix[ir-1][endC];
			}
			for(int ic=endC; ic>startC+1; ic--) {
				copyMatrix[startR][ic] = copyMatrix[startR][ic-1];
			}
			copyMatrix[startR][startC+1] = temp;
		}
		
	}
}