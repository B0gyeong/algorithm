import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int cnt = 0;
			int N = sc.nextInt();
			int [][] matrix = new int[N][N];
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					matrix[row][col] = sc.nextInt(); 
				}
			}
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					if(matrix[row][col]==1) {
						for(int x=row+1; x<N; x++) {
							if(matrix[x][col]==2) {
								cnt++;
								break;
							} else if(matrix[x][col]==1) {
								break;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
