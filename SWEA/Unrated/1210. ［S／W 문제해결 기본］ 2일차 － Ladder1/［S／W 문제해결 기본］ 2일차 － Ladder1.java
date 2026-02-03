import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int testCase = sc.nextInt();
			int N = 100;
			int start = -1;
			int [][] matrix = new int[N][N];
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					int num = sc.nextInt(); 
					if(num == 2) {
						start = col;
					}
					matrix[row][col] = num;
				}
			}
			int curRow = 99;
			int curCol = start;
			while (curRow != 0) {
				if(0 <= curCol-1 && matrix[curRow][curCol-1] == 1) {
					curCol--;
					while(matrix[curRow-1][curCol]!=1) {
						curCol--;
					}
				}
				else if(curCol+1<100 && matrix[curRow][curCol+1] == 1) {
					curCol++;
					while(matrix[curRow-1][curCol]!=1) {
						curCol++;
					}
				}
				curRow--;
			}
			System.out.println("#"+testCase+" "+curCol);
		}
	}
}
