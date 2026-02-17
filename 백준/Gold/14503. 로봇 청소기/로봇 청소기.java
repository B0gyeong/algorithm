import java.util.*;

public class Main {
	static int N;
	static int M;
	static int d;
	static int cnt;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int [][] matrix;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	int str = sc.nextInt();
    	int stc = sc.nextInt();
    	d = sc.nextInt();
    	
    	matrix = new int [N][M];
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			matrix[r][c] = sc.nextInt();
    		}
    	}
    	
    	cnt = 0;
    	solve(str, stc);
    	System.out.println(cnt);
	}
    
	private static void solve(int r, int c) {
		if(matrix[r][c] == 0) {
			matrix[r][c] = 2;
			cnt++;
		} 
		
		for(int i=0; i<4; i++) {
			d = (d+3)%4;
			int nr = r + dr[d];
            int nc = c + dc[d];
            
			if(!isWall(nr,nc) && matrix[nr][nc]==0) {
				solve(nr,nc);
				return;
			} 
		}
		
		int backD = (d + 2) % 4; 
        int br = r + dr[backD];
        int bc = c + dc[backD];

        if (!isWall(br, bc) && matrix[br][bc] != 1) {
            solve(br, bc);
        }
	}

	private static boolean isWall(int nr, int nc) {
		return nr<0 || nr>=N || nc<0 || nc>=M;
	}
}