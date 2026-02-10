import java.util.*;

public class Main {
	static int N;
	static int cnt;
	static int [][] matrix;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	matrix = new int [N+1][N+1];
    	for(int r=1; r<=N; r++) {
    		for(int c=1; c<=N; c++) {
    			matrix[r][c] = sc.nextInt();
    		}
    	}
    	
    	cnt = 0;
    	solve(0, 1, 2);
    	System.out.println(cnt);
	}
    
	private static void solve(int state, int r, int c) {
		if(r==N && c==N) {
			cnt++;
			return;
		}
		// 가로로 가는 방법
		if(state == 0 || state == 2) {
			if(c+1<=N && matrix[r][c+1] != 1) {
				solve(0, r, c+1);
			}
		}
		// 세로로 가는 방법
		if(state == 1 || state == 2) {
			if(r+1<=N && matrix[r+1][c] != 1) {
				solve(1, r+1, c);
			}
		}
		// 대각선
		if(r+1<=N && c+1<=N && matrix[r][c+1] != 1 && matrix[r+1][c] != 1 && matrix[r+1][c+1] != 1) {
			solve(2, r+1, c+1);
		}
	}
}

