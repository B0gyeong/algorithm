import java.util.*;

public class Solution {
	static int N;
	static int minDiff;
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;
	static int [][] matrix;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			matrix = new int [N][N];
			visited = new boolean [N];
			minDiff = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					matrix[r][c] = sc.nextInt();
				}
			}
			
			comb(0,0);
			System.out.println("#"+tc+" "+minDiff);
		}
	}
	
	private static void comb(int k, int s) {
		if(k == N/2) {
			A = new ArrayList<>();
			B = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			calculDiff();
		} else {
			for(int i=s; i<N; i++) {
				visited[i] = true;
				comb(k+1, i+1);
				visited[i] = false;
			}
		}
		
	}

	private static void calculDiff() {
		int aSum = 0; int bSum = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i+1; j<N/2; j++) {
				aSum += matrix[A.get(i)][A.get(j)];
				aSum += matrix[A.get(j)][A.get(i)];
				bSum += matrix[B.get(i)][B.get(j)];
				bSum += matrix[B.get(j)][B.get(i)];
			}
		}
		if(Math.abs(aSum-bSum) < minDiff) minDiff = Math.abs(aSum-bSum);
	}
}