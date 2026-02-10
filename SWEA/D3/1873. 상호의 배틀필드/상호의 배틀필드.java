import java.util.*;

public class Solution {
	static int H;
	static int W;
	static int curR;
	static int curC;
    static char [][] matrix;
    static class CCTV {
    	int r, c, type;
    	CCTV (int r, int c, int type){
    		this.r = r; this.c = c; this.type = type;
    	}
    }
    static List<CCTV> cctvs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			matrix = new char [H][W];
			for(int r=0; r<H; r++) {
				String line = sc.next();
				for(int c=0; c<W; c++) {
					matrix[r][c] = line.charAt(c);
					if(matrix[r][c]=='>' || matrix[r][c]=='^' || matrix[r][c]=='<' || matrix[r][c]=='v') {
						curR = r; curC = c;
					}
				}
			}
			int N = sc.nextInt();
			String commands = sc.next();
			for(int i=0; i<N; i++) {
				char command = commands.charAt(i);
				move(command);
			}
			System.out.print("#"+tc+" ");
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					System.out.print(matrix[r][c]);
				}
				System.out.println();
			}
		}
	}
	
	private static void move(char c) {
		if(c == 'U') {
			if(curR-1 >= 0 && matrix[curR-1][curC] == '.') {
				matrix[curR][curC] = '.';
				curR -= 1;
				matrix[curR][curC] = '^';
			} else {
				matrix[curR][curC] = '^';
			}
		} else if (c == 'D') {
			if(curR+1 < H && matrix[curR+1][curC] == '.') {
				matrix[curR][curC] = '.';
				curR += 1;
				matrix[curR][curC] = 'v';
			} else {
				matrix[curR][curC] = 'v';
			}
		} else if (c == 'L') {
			if(curC-1 >= 0 && matrix[curR][curC-1] == '.') {
				matrix[curR][curC] = '.';
				curC -= 1;
				matrix[curR][curC] = '<';
			} else {
				matrix[curR][curC] = '<';
			}
		} else if (c == 'R') {
			if(curC+1 < W && matrix[curR][curC+1] == '.') {
				matrix[curR][curC] = '.';
				curC += 1;
				matrix[curR][curC] = '>';
			} else {
				matrix[curR][curC] = '>';
			}
		} else {
			char curVal = matrix[curR][curC];
			if(curVal == '^') {
				for(int i=curR-1; i>=0; i--) {
					if(matrix[i][curC]=='*') {
						matrix[i][curC] = '.';
						break;
					}
					if(matrix[i][curC]=='#') break;
				}
			} else if(curVal == '<') {
				for(int i=curC-1; i>=0; i--) {
					if(matrix[curR][i]=='*') {
						matrix[curR][i] = '.';
						break;
					}
					if(matrix[curR][i]=='#') break;
				}
			} else if(curVal == '>') {
				for(int i=curC+1; i<W; i++) {
					if(matrix[curR][i]=='*') {
						matrix[curR][i] = '.';
						break;
					}
					if(matrix[curR][i]=='#') break;
				}
			} else {
				for(int i=curR+1; i<H; i++) {
					if(matrix[i][curC]=='*') {
						matrix[i][curC] = '.';
						break;
					}
					if(matrix[i][curC]=='#') break;
				}
			}
		}
		
	}
}