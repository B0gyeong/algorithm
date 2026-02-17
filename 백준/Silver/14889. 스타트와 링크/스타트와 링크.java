import java.util.*;

public class Main {
	static int N, minDiff;
	static boolean [] visited;
	static int [][] matrix;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	matrix = new int [N][N];
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<N; c++) {
    			matrix[r][c] = sc.nextInt();
    		}
    	}
    	
    	minDiff = Integer.MAX_VALUE;
    	visited = new boolean [N];
    	visited[0] = true;
    	solve(1, 1);
    	System.out.println(minDiff);
	}

	private static void solve(int idx, int s) {
		if(idx==N/2) {
			calculate();
			return;
		}
		
		for(int i=s; i<N; i++) {
			visited[i] = true;
			solve(idx+1, i+1);
			visited[i] = false;
		}
		
	}

	private static void calculate() {
		List <Integer> start = new ArrayList<>();
		List <Integer> link = new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				start.add(i);
			}
			else {
				link.add(i);
			}
			
		}

		int sSum = 0;
		int lSum = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i; j<N/2; j++) {
				sSum += matrix[start.get(i)][start.get(j)];
				sSum += matrix[start.get(j)][start.get(i)];
				lSum += matrix[link.get(i)][link.get(j)];
				lSum += matrix[link.get(j)][link.get(i)];
			}
		}
		minDiff = Math.min(minDiff, Math.abs(sSum-lSum));
	}
}