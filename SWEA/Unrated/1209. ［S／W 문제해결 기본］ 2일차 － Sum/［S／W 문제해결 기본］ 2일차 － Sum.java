import java.util.*;
public class Solution {
	private static int rowMax(int max, int[][] matrix) {
		int maxFinal = max;
		for(int row=0; row<100; row++) {
			int num = 0;
			for(int col=0; col<100; col++) {
				num += matrix[row][col];
			}
			maxFinal = Math.max(num, maxFinal);
		}
		return maxFinal;
	}
	private static int colMax(int max, int[][] matrix) {
		int maxFinal = max;
		for(int col=0; col<100; col++) {
			int num = 0;
			for(int row=0; row<100; row++) {
				num += matrix[row][col];
			}
			maxFinal = Math.max(num, maxFinal);
		}
		return maxFinal;
	}
	private static int crossMax(int max, int[][] matrix) {
		int maxFinal = max;
		int numA = 0;
		int numB = 0;
		for(int row=0; row<100; row++) {
			numA += matrix[row][row];
		}
		for(int row=0; row<100; row++) {
			numB += matrix[99-row][row];
		}
		maxFinal = Math.max(Math.max(numA,numB), maxFinal);
		return maxFinal;
	}
	
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
			max = rowMax(max, matrix);
			max = colMax(max, matrix);
			max = crossMax(max, matrix);
			System.out.println("#"+testCase+" "+max);
		}
	}
}
