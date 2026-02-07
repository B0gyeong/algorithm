import java.util.*;

public class Main {
	static int N;
	static boolean [] visited;
	static int [][] matrix;
	static int minAns;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		matrix = new int [N][N];
		
		visited = new boolean [N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}
		minAns = 100000;
		comb(0, 0);
		
		System.out.println(minAns);
	}

	private static void comb(int k, int s) {
		if(k == N/2) {
			ArrayList<Integer> start = new ArrayList<>();
			ArrayList<Integer> link = new ArrayList<>();
			int startSum = 0;
			int linkSum = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					start.add(i);
				} else {
					link.add(i);
				}
			}
			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					if(i != j) {
						startSum+=matrix[start.get(i)][start.get(j)];
						linkSum+=matrix[link.get(i)][link.get(j)];
					}
				}
			}
			
			int abSum = Math.abs(startSum-linkSum);
			minAns = Math.min(minAns, abSum);
		} else {
			for(int i=s; i< N; i++) {
				visited[i] = true;
				comb(k+1, i+1);
				visited[i] = false;
			}
		}
		
	}
}