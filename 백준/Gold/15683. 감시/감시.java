import java.util.*;

public class Main {
	static int N;
	static int M;
	static int minBlindSpot;
	static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dc = {0, 1, 0, -1};
    static int [][] matrix;
    static class CCTV {
    	int r, c, type;
    	CCTV (int r, int c, int type){
    		this.r = r; this.c = c; this.type = type;
    	}
    }
    static List<CCTV> cctvs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		matrix = new int [N][M];
		cctvs = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				matrix[r][c] = sc.nextInt();
				if(matrix[r][c] != 0 && matrix[r][c] != 6) {
					cctvs.add(new CCTV(r,c,matrix[r][c]));
				}
			}
		}
		
		minBlindSpot = Integer.MAX_VALUE;
		solve(0, matrix);
		System.out.println(minBlindSpot);
		
	}
	
	private static void solve(int cctvIdx, int[][]map) {
		if(cctvIdx == cctvs.size()) {
			minBlindSpot = Math.min(minBlindSpot, countBlindSpot(map));
			return;
		} 
		
		CCTV curr = cctvs.get(cctvIdx);
		for(int d=0; d<4; d++) {
			int [][] nextMap = copyMap(map);
			watch(curr, d, nextMap);
			solve(cctvIdx+1, nextMap);
		}
	}

	private static void watch(CCTV curr, int d, int[][] map) {
		int type = curr.type;
		int r = curr.r;
		int c = curr.c;
		if(type == 1) {
			draw(r, c, d, map);
		}
		if(type == 2) {
			draw(r, c, d, map);
			draw(r, c, (d+2)%4, map);
		}
		if(type == 3) {
			draw(r, c, d, map);
			draw(r, c, (d+1)%4, map);
		}
		if(type == 4) {
			draw(r, c, d, map);
			draw(r, c, (d+1)%4, map);
			draw(r, c, (d+2)%4, map);
		}
		if(type == 5) {
			draw(r, c, d, map);
			draw(r, c, (d+1)%4, map);
			draw(r, c, (d+2)%4, map);
			draw(r, c, (d+3)%4, map);
		}
	}
	
	private static void draw(int r, int c, int d, int[][] map) {
	    int nr = r + dr[d];
	    int nc = c + dc[d];
	    while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
	        if (map[nr][nc] == 0) map[nr][nc] = 7;
	        nr += dr[d];
	        nc += dc[d];
	    }
	}

	private static int[][] copyMap(int[][] map) {
		int [][] nextMap = new int [N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				nextMap[r][c] = map[r][c];
			}
		}
		return nextMap;
	}

	private static int countBlindSpot(int[][] map) {
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) cnt++;
			}
		}
		return cnt;
	}
}