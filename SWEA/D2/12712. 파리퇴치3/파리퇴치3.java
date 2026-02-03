import java.util.*;
public class Solution{
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
			int [] dx = {-1,1,0,0};
			int [] dy = {0,0,-1,1};
			int [] dcr = {-1, 1, -1, 1 };
			int [] dcc = {-1, 1, 1, -1 };
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					int lineTotal = matrix[row][col];
					int crossTotal = matrix[row][col];
					for(int m=1; m<M; m++) {
						for(int d=0; d<4; d++) {
							int nr = row + dx[d] * m;
					        int nc = col + dy[d] * m;
							if(0<=nr && nr<N && 0<=nc && nc <N) {
								lineTotal += matrix[nr][nc];
							}
							int ncr = row + dcr[d] * m;
					        int ncc = col + dcc[d] * m;
							if(0<=ncr && ncr<N && 0<=ncc && ncc<N) {
								crossTotal += matrix[ncr][ncc];
							}
						}
					}
					ans = Math.max(ans, Math.max(lineTotal, crossTotal));
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}