import java.util.*;

public class Main {
	public static boolean isWall (int row, int col, int N) {
		return row<0 || row>=N || col<0 || col>=N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] matrix = new int [N][N];
		
		int maxH = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = sc.nextInt();
				maxH = Math.max(maxH, matrix[i][j]);
			}
		}
		
		int maxSafe = 0;
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		for(int rain=0; rain<maxH; rain++) {
			int safe = 0;
			Stack<Integer> st = new Stack<>();
			boolean [][] visited = new boolean [N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(matrix[i][j] > rain && !visited[i][j]) {
						st.push(i*N+j);
						visited[i][j] = true;
						while(!st.isEmpty()) {
							int num = st.pop();
							int cr = num / N;
							int cc = num % N;
							for(int d=0; d<4; d++) {
								int nr = cr+dx[d];
								int nc = cc+dy[d];
								if(!isWall(nr,nc,N) && !visited[nr][nc] && matrix[nr][nc] > rain) {
									st.push(nr*N+nc);
									visited[nr][nc] = true;
								}
							}
						}
						safe++;
					}
				}
			}
			maxSafe = Math.max(safe, maxSafe);
		}
		System.out.println(maxSafe);
	}
}