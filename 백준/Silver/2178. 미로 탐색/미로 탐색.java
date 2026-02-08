import java.util.*;

public class Main {
	static int N; static int M;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int [][] matrix;
	static boolean [][] visited;
	static class Node{
		int r, c, dist;
		Node(int r, int c, int dist){
			this.r = r; this.c = c; this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		matrix = new int [N][M];
		visited = new boolean [N][M];
		
		for(int r=0; r<N; r++) {
			String line = sc.next();
			for(int c=0; c<M; c++) {
				matrix[r][c] = line.charAt(c)-'0';
			}
		}
		
		int ans = BFS();
		System.out.print(ans);
	}

	private static int BFS() {
		Queue<Node> q = new LinkedList();
		int cnt = 1;
		
		q.add(new Node(0,0,1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			cnt++;
			if(curr.r == N-1 && curr.c == M-1) return curr.dist;
			for(int d=0; d<4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(!isWall(nr, nc) && matrix[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Node(nr,nc, curr.dist + 1));
					visited[nr][nc] = true;
				}
			}
		}
		
		return -1;
	}

	private static boolean isWall(int nr, int nc) {
		return nr<0 || nr>=N || nc<0 || nc>=M;
	}
}