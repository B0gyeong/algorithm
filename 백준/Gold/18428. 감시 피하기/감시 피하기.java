import java.util.*;

public class Main {	
	static int N;
	static boolean success;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static char [][] matrix;
	static List<Node> teachers;
	static class Node {
		int r, c;
		Node (int r, int c) {
			this.r = r; this.c = c;
		}
	}
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        teachers = new ArrayList<>();
        matrix = new char [N][N];
        for(int r=0; r<N; r++) {
        	for(int c=0; c<N; c++) {
        		matrix[r][c] = sc.next().charAt(0);
        		if(matrix[r][c] == 'T') {
        			teachers.add(new Node(r,c));
        		}
        	}
        }
        
        success = false;
        comb(0, 0);
        System.out.println(success ? "YES" : "NO");
	}
    
	private static void comb(int idx, int start) {
		if(idx == 3) {
			if(checkVaild()) success = true;
			return;
		}
		
		if(success) return;
		
		for(int i=0; i<N*N; i++) {
			int r = i / N;
			int c = i % N;
			
			if(matrix[r][c] != 'X') continue;
			
			matrix[r][c] = 'O';
			comb(idx+1, i+1);
			matrix[r][c] = 'X';
		}
	}

	private static boolean checkVaild() {
		for(int i=0; i<teachers.size(); i++) {
			if(!checkT(teachers.get(i))) return false;
		}
		return true;
	}

	private static boolean checkT(Main.Node node) {
		for(int d=0; d<4; d++) {
			int nr = node.r + dr[d];
			int nc = node.c + dc[d];
			while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(matrix[nr][nc] == 'O') break;
				else if (matrix[nr][nc] == 'S') return false;
				nr = nr + dr[d];
				nc = nc + dc[d];
			}
		}
		return true;
	}
}