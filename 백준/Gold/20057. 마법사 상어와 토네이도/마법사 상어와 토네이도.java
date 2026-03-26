import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {-1, 0, 1, 0};
	static int [][] map;
	static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
    	map = new int [N][N];
    	for (int r=0; r<N; r++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int c=0; c<N; c++) {
    			map[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int r = N / 2;
    	int c = N / 2;
    	visited = new boolean [N][N];
    	visited[r][c] = true;
    	ans = 0;
    	
    	tornado(r,c);
    	
    	System.out.println(ans);
    }
    
	private static void tornado(int r, int c) {
		// TODO Auto-generated method stub
		int d = 3;
		
		while(true) {
			if(!visited[r + dr[(d+1) % 4]][c + dc[(d+1) % 4]]) {
				d = (d+1) % 4;
				
				r = r + dr[d];
				c = c + dc[d];
				
			} else {
				r = r + dr[d];
				c = c + dc[d];
			}
			
			visited[r][c] = true;
			
			int sand100 = map[r][c];
			double sand10 = sand100 * 0.1;
			double sand7 = sand100 * 0.07;
			double sand5 = sand100 * 0.05;
			double sand2 = sand100 * 0.02;
			double sand1 = sand100 * 0.01;
			int rest = sand100 - 2*(int)sand10 - 2*(int)sand7 - (int)sand5 - 2*(int)sand2 - 2*(int)sand1;
			map[r + dr[(d+2)%4]][c + dc[(d+2)%4]] = 0;

			if(d==0 || d==2) {
				//10
				if(!isWall(r + dr[d] + dr[1], c + dc[d] + dc[1])) {
					map[r + dr[d] + dr[1]][c + dc[d] + dc[1]] += (int)sand10;
				} else {
					ans += (int)sand10;
				}
				if(!isWall(r + dr[d] + dr[3], c + dc[d] + dc[3])) {
					map[r + dr[d] + dr[3]][c + dc[d] + dc[3]] += (int)sand10;
				} else {
					ans += (int)sand10;
				}
				
				// 7
				if(!isWall(r + dr[1], c + dc[1])) {
					map[r + dr[1]][c + dc[1]] += (int)sand7;
				} else {
					ans += (int)sand7;
				}
				if(!isWall(r + dr[3], c + dc[3])) {
					map[r + dr[3]][c + dc[3]] += (int)sand7;
				} else {
					ans += (int)sand7;
				}
				
				//2
				if(!isWall(r + 2*dr[1], c + 2*dc[1])) {
					map[r + 2*dr[1]][c + 2*dc[1]] += (int)sand2;
				} else {
					ans += (int)sand2;
				}
				if(!isWall(r + 2*dr[3], c + 2*dc[3])) {
					map[r + 2*dr[3]][c + 2*dc[3]] += (int)sand2;
				} else {
					ans += (int)sand2;
				}
				
				//1
				if(!isWall(r + dr[(d+2)%4] + dr[1], c + dc[(d+2)%4] +dc[1])) {
					map[r + dr[(d+2)%4] + dr[1]][c + dc[(d+2)%4] + dc[1]] += (int)sand1;
				} else {
					ans += (int)sand1;
				}
				if(!isWall(r + dr[(d+2)%4] + dr[3], c + dc[(d+2)%4] + dc[3])) {
					map[r + dr[(d+2)%4] + dr[3]][c + dc[(d+2)%4] + dc[3]] += (int)sand1;
				} else {
					ans += (int)sand1;
				}
				
			} else {
				if(!isWall(r + dr[d] + dr[0], c + dc[d] +dc[0])) {
					map[r + dr[d] + dr[0]][c + dc[d] + dc[0]] += (int)sand10;
				} else {
					ans += (int)sand10;
				}
				if(!isWall(r + dr[d] + dr[2], c + dc[d]+ dc[2])) {
					map[r + dr[d] + dr[2]][c + dc[d] + dc[2]] += (int)sand10;
				} else {
					ans += (int)sand10;
				}
				
				// 7
				if(!isWall(r + dr[0], c + dc[0])) {
					map[r + dr[0]][c + dc[0]] += (int)sand7;
				} else {
					ans += (int)sand7;
				}
				if(!isWall(r + dr[2], c + dc[2])) {
					map[r + dr[2]][c + dc[2]] += (int)sand7;
				} else {
					ans += (int)sand7;
				}
				
				//2
				if(!isWall(r + 2*dr[0], c + 2*dc[0])) {
					map[r + 2*dr[0]][c + 2*dc[0]] += (int)sand2;
				} else {
					ans += (int)sand2;
				}
				if(!isWall(r + 2*dr[2], c + 2*dc[2])) {
					map[r + 2*dr[2]][c + 2*dc[2]] += (int)sand2;
				} else {
					ans += (int)sand2;
				}
				
				//1
				if(!isWall(r + dr[(d+2)%4] + dr[0], c + dc[(d+2)%4] +dc[0])) {
					map[r + dr[(d+2)%4] + dr[0]][c + dc[(d+2)%4] + dc[0]] += (int)sand1;
				} else {
					ans += (int)sand1;
				}
				if(!isWall(r + dr[(d+2)%4] + dr[2], c + dc[(d+2)%4] + dc[2])) {
					map[r + dr[(d+2)%4] + dr[2]][c + dc[(d+2)%4] + dc[2]] += (int)sand1;
				} else {
					ans += (int)sand1;
				}
				
			}
			
			// 5
			if(!isWall(r + 2*dr[d], c + 2*dc[d])) {
				map[r + 2*dr[d]][c + 2*dc[d]] += (int)sand5;
			} else {
				ans += (int)sand5;
			}
			
			
			// rest
			if(!isWall(r + dr[d], c + dc[d])) {
				map[r + dr[d]][c + dc[d]] += (int)rest;
			} else {
				ans += (int)rest;
			}
			
			if(r == 0 && c == 0) {
				break;
			}
		}
		

	}

	private static boolean isWall(int i, int j) {
		// TODO Auto-generated method stub
		return i<0 || i>=N || j<0 || j>=N;
	}
}

