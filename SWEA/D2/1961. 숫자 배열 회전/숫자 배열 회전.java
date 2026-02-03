import java.util.*;

public class Solution {
	private static void turn90(int[][] matrix, int[][] matrix90 , int N) {
		for(int row=0; row<N; row++) {
    		for(int col=0; col<N; col++) {
    			matrix90[row][col] = matrix[N-1-col][row];
    		}
    	}
		
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	int N = sc.nextInt();
        	int [][] matrix = new int [N][N];
        	for(int row=0; row<N; row++) {
        		for(int col=0; col<N; col++) {
        			matrix[row][col] = sc.nextInt();
        		}
        	}
        	int [][] matrix90 = new int [N][N];
        	int [][] matrix180 = new int [N][N];
        	int [][] matrix270 = new int [N][N];
        	turn90(matrix,matrix90,N);
        	turn90(matrix90,matrix180,N);
        	turn90(matrix180,matrix270,N);
        	
        	System.out.println("#"+tc);
            StringBuilder sb = new StringBuilder();
        	for(int row=0; row<N; row++) {
        		for(int col=0; col<N; col++) {
        			sb.append(matrix90[row][col]);
        		}
        		sb.append(" ");
        		for(int col=0; col<N; col++) {
        			sb.append(matrix180[row][col]);
        		}
        		sb.append(" ");
        		for(int col=0; col<N; col++) {
        			sb.append(matrix270[row][col]);
        		}
        		sb.append("\n");
        	}
            System.out.print(sb.toString());
        }
    }

	
}