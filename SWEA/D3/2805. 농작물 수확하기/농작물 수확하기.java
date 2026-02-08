import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			int [][] matrix = new int [N][N];
			for(int r=0; r<N; r++) {
				String line = sc.next();
				for(int c=0; c<N; c++) {
					matrix[r][c] = line.charAt(c)-'0';
				}
			}
			
			int center = N/2;
			for(int i=0; i<center; i++) {
				for(int j=center-i; j<center+i+1; j++) {
					ans += matrix[i][j];
				}
			}
			int colIdx = center;
			for(int i=center; i<N; i++) {
				for(int j=center-colIdx; j<center+colIdx+1; j++) {
					ans += matrix[i][j];
				}
				colIdx--;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}