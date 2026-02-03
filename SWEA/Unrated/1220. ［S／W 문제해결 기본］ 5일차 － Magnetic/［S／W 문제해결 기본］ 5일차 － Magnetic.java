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
            for(int col=0; col<N; col++) {
            	int isN = 0;
                for(int row=0; row<N; row++) {
                    if(matrix[row][col]==1) {
                    	isN = 1;
                    } else if(matrix[row][col]==2) {
                    	if(isN == 1) {
                    		cnt++;
                    		isN = 0;
                    	}
                    }
                }
            }
            System.out.println("#"+tc+" "+cnt);
        }
	}
}
