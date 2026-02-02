import java.util.*;

public class Main {
	public static int check(int[][] matrix, int num, boolean[][] checkBool) {
		for(int row=0; row<5; row++) {
			for(int col=0; col<5; col++) {
				if(matrix[row][col]==num) {
					checkBool[row][col] = true;
					break;
				}
			}
		}
        return 0; 
    }
	public static boolean checkBing(boolean[][] checkBool) {
		int checkNum = 0;
		for(int row=0; row<5; row++) {
			for(int col=0; col<5; col++) {
				if(!checkBool[row][col]) {
					break;
				}
				if(col==4) {
					checkNum++;
				}
			}
		}
		for(int col=0; col<5; col++) {
			for(int row=0; row<5; row++) {
				if(!checkBool[row][col]) {
					break;
				}
				if(row==4) {
					checkNum++;
				}
			}
		}
		for(int row=0; row<5; row++) {
			if(!checkBool[row][row]) {
				break;
			}
			if(row==4) {
				checkNum++;
			}
		}
		for(int col=0; col<5; col++) {
			if(!checkBool[4-col][col]) {
				break;
			}
			if(col==4) {
				checkNum++;
			}
		}
		if(checkNum >=3) {
			return true;
		}else {
			return false; 
		}
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] matrix = new int[5][5];
		int [][] ansMatrix = new int[5][5];
		boolean [][] checkBool = new boolean[5][5];
		int cnt = 0;
		for(int row=0; row<5; row++) {
			for(int col=0; col<5; col++) {
				matrix[row][col] = sc.nextInt();
			}
		}
		for(int row=0; row<5; row++) {
			for(int col=0; col<5; col++) {
				ansMatrix[row][col] = sc.nextInt();
			}
		}
		for(int row=0; row<5; row++) {
			for(int col=0; col<5; col++) {
				check(matrix,ansMatrix[row][col],checkBool);
				cnt++;
				if(checkBing(checkBool)) {
					System.out.println(cnt);
					return;
				}
				
			}
		}
	}
}
