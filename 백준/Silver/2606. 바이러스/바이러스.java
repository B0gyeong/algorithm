import java.util.*;

public class Main {
	static int N; static int M;
	static int [][] matrix;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		matrix = new int [N+1][N+1];
		visited = new boolean [N+1];
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		int cnt = DFS();
		System.out.println(cnt-1);
	}

	private static int DFS() {
		Stack<Integer> st = new Stack<>();
		int cnt = 0;
		
		st.push(1);
		
		while(!st.isEmpty()) {
			int curr = st.pop();
			
			if(visited[curr]) continue;
			visited[curr] = true;
			cnt++;
			
			for(int i=1; i<=N; i++) {
				if(matrix[curr][i]==1) {
					st.push(i);
				}
			}
			
		}
		return cnt;
	}
}