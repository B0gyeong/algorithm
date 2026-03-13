import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		for(int r=0; r<N; r++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(line.nextToken());
			}
		}
		
		int sum = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<=M-4; c++) {
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r][c+2] + map[r][c+3]);
			}
		}
		
		for(int r=0; r<=N-4; r++) {
			for(int c=0; c<M; c++) {
				sum = Math.max(sum, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+3][c]);
			}
		}
		
		for(int r=0; r<=N-2; r++) {
			for(int c=0; c<=M-2; c++) {
				sum = Math.max(sum, map[r][c] + map[r+1][c+1] + map[r+1][c] + map[r][c+1]);
			}
		}
		
		for(int r=0; r<=N-3; r++) {
			for(int c=0; c<=M-2; c++) {
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r+2][c+1]);
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r+1][c] + map[r+2][c]);
				sum = Math.max(sum, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+2][c+1]);
				sum = Math.max(sum, map[r][c+1] + map[r+1][c+1] + map[r+2][c+1] + map[r+2][c]);
				
				sum = Math.max(sum, map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+2][c+1]);
				sum = Math.max(sum, map[r][c+1] + map[r+1][c] + map[r+1][c+1] + map[r+2][c]);
				
				sum = Math.max(sum, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+1][c+1]);
				sum = Math.max(sum, map[r][c+1] + map[r+1][c+1] + map[r+2][c+1] + map[r+1][c]);
			}
		}
		
		for(int r=0; r<=N-2; r++) {
			for(int c=0; c<=M-3; c++) {
				sum = Math.max(sum, map[r+1][c] + map[r+1][c+1] + map[r+1][c+2] + map[r][c+2]);
				sum = Math.max(sum, map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+1][c+2]);
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c]);
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+2]);
				
				sum = Math.max(sum, map[r][c+1] + map[r][c+2] + map[r+1][c] + map[r+1][c+1]);
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r+1][c+2]);
				
				sum = Math.max(sum, map[r][c+1] + map[r+1][c] + map[r+1][c+1] + map[r+1][c+2]);
				sum = Math.max(sum, map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+1]);
			}
		}
		
		System.out.println(sum);
	}

}
			
			
