import java.util.*;

public class Main {
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static int rNum;
	static int cNum;
	static char [][] matrix;
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r; this.c = c;
		}
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	rNum = sc.nextInt();
    	cNum = sc.nextInt();
    	matrix = new char [rNum][cNum];
    	for(int i=0; i<rNum; i++) {
    		String line = sc.next();
    		for(int j=0; j<cNum; j++) {
    			matrix[i][j] = line.charAt(j); 
    		}
    	}
    	
    	int maxLength = 0;
    	for(int i=0; i<rNum; i++) {
    		for(int j=0; j<cNum; j++) {
    			if(matrix[i][j]=='L') {
    				int L = BFS(i, j);
    				maxLength = Math.max(maxLength, L);
    			}
    		}
    	}
    	System.out.println(maxLength-1);
	}

	private static int BFS(int r, int c) {
		boolean [][] visited = new boolean [rNum][cNum];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visited[r][c]= true;
		
		int level = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			for(int i=0; i<len; i++) {
				Node curr = q.poll();
				for(int d=0; d<4; d++) {
					int nr = curr.r+dr[d];
					int nc = curr.c+dc[d];
					if(isLand(nr, nc) && !visited[nr][nc]) {
						q.add(new Node(nr, nc));
						visited[nr][nc]= true;
					}
				}
			}
			level++;
		}
		return level;
	}

	private static boolean isLand(int nr, int nc) {
		return 0 <= nr && nr< rNum && 0 <= nc && nc< cNum && matrix[nr][nc] == 'L';
	}	
}
