import java.util.*;

public class Main {	
	static int maxAns;
	static int [][] matrix;
	static boolean [] visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int tc=1; tc<=C; tc++) {
			
			matrix = new int [11][11];
			for(int r=0; r<11; r++) {
				for(int c=0; c<11; c++) {
					matrix[r][c] = sc.nextInt();
				}
			}
			
			maxAns = Integer.MIN_VALUE;
			visited = new boolean [11];
			perm(0, 0);
			System.out.println(maxAns);
		}
	}
    
	private static void perm(int idx, int sum) {
		if(idx == 11) {
			maxAns = Math.max(maxAns, sum);
			return;
		}
		
		for(int i=0; i<11; i++) {
			if(visited[i] || matrix[idx][i] == 0) continue;
			
			visited[i] = true;
			perm(idx+1, sum+matrix[idx][i]);
			visited[i] = false;
		}
	}
}