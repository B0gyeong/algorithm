import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int [][] matrix = new int [N][N];
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					matrix[row][col] = sc.nextInt();
				}
			}
			int ans = 0;
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					int lineTotal = matrix[row][col];
					int crossTotal = matrix[row][col];
					for(int i=1; i<M; i++) {
						if(0<=row-i) lineTotal += matrix[row-i][col];
						if(row+i<N) lineTotal += matrix[row+i][col];
						if(0<=col-i) lineTotal += matrix[row][col-i];
						if(col+i<N) lineTotal += matrix[row][col+i];
						if(0<=row-i && 0<=col-i) crossTotal += matrix[row-i][col-i];
						if(0<=row-i && col+i<N) crossTotal += matrix[row-i][col+i];
						if(row+i<N && 0<=col-i) crossTotal += matrix[row+i][col-i];
						if(row+i<N && col+i<N) crossTotal += matrix[row+i][col+i];
					}
					ans = Math.max(ans, Math.max(lineTotal, crossTotal));
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}