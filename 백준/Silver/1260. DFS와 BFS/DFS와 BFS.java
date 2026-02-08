import java.util.*;

public class Main {
	static int N; static int M; 
	static int [][] matrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); M = sc.nextInt();
		int V = sc.nextInt();
		matrix = new int [N+1][N+1];
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		DFS(V);
		BFS(V);
	}
	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean [N+1];
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
	        System.out.print(cur + " ");

			for(int i=1; i<N+1; i++) {
				if(matrix[cur][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println();
		
	}
	private static void DFS(int v) {
		Stack<Integer> st = new Stack<>();
		boolean [] visited = new boolean [N+1];
		
		st.push(v);
		
		while(!st.isEmpty()) {
			int cur = st.pop();
			
			if (visited[cur]) continue; 
	        visited[cur] = true;
	        System.out.print(cur + " ");

			for(int i=N; i>0; i--) {
				if(matrix[cur][i] == 1 && !visited[i]) {
					st.push(i);
				}
			}
		}
		System.out.println();
	}
}