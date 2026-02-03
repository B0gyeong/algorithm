import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int testCase = sc.nextInt();
            int N = 100;
            int max = 0;
            int [][] matrix = new int[N][N];
            for(int row=0; row<N; row++) {
                for(int col=0; col<N; col++) {
                    matrix[row][col] = sc.nextInt(); 
                }
            }
            int finalMax = 0;
            int diaSum1 = 0;
            int diaSum2 = 0;
            
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += matrix[i][j]; 
                    colSum += matrix[j][i]; 
                }
                finalMax = Math.max(finalMax, Math.max(rowSum, colSum));
                diaSum1 += matrix[i][i];
                diaSum2 += matrix[i][99 - i];
            }
            finalMax = Math.max(finalMax, Math.max(diaSum1, diaSum2));
            
            System.out.println("#"+testCase+" "+finalMax);
        }
	}
}
