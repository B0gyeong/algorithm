import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int k = sc.nextInt();
		if(k > C*R) {
			System.out.println(0);
			return;
		}
		boolean [][] visited = new boolean[R][C];
		int [][] matrix = new int[R][C];
		
		int cnt = 1;
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		int d = 0;
		int ix = R-1;
		int iy = 0;
		while (cnt <= R*C) {
			matrix[ix][iy] = cnt++;
			visited[ix][iy] = true;
			if((0<=ix+dx[d] && ix+dx[d]<R) && (0<=iy+dy[d] && iy+dy[d]<C) && (!visited[ix+dx[d]][iy+dy[d]])) {
				ix = ix+dx[d];
				iy = iy+dy[d];
			} else {
				d+=1;
				d%=4;
				ix = ix+dx[d];
				iy = iy+dy[d];
			}
		}
		for(int row=0; row<R; row++) {
			for(int col=0; col<C; col++) {
				if(matrix[row][col]==k ) {
					System.out.println((col+1)+" "+(R-row));
					break;
				}
			}
		}
	}
}
