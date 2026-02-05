import java.util.*;

public class Main{
	public static int M;
	public static int N;
	public static int[] dx= {-1, 1, 0, 0};
	public static int[] dy= {0, 0, -1, 1};
	public static boolean [][] visited;
	public static int [][] matrix;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=0; tc<T; tc++) {
    		M = sc.nextInt();
    		N = sc.nextInt();
    		matrix = new int [M][N];
    		int K = sc.nextInt();
    		for(int i=0; i<K; i++) {
    			int r = sc.nextInt();
    			int c = sc.nextInt();
    			matrix[r][c] = 1;
    		}
    		
    		int cnt = 0;
    		visited = new boolean [M][N];
    		for(int i=0; i<M; i++) {
    			for(int j=0; j<N; j++) {
    				if(matrix[i][j]==1 && !visited[i][j] ) {
    					dfs(i,j);
    					cnt++;
    				}
    			}
    		}
    		System.out.println(cnt);
    	}
    }

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(0<=nx && nx<M && 0<=ny && ny<N && matrix[nx][ny]==1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}	
}
