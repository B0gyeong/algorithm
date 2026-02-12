import java.util.*;

public class Solution {
    static int N;
    static int W; static int H;
    static int minCnt;
    static int [] select;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
    static int [][] matrix;
    static int [][] copyMatrix;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            matrix = new int [H][W];
            copyMatrix = new int [H][W];
            select = new int [N];
            for(int r=0; r<H; r++) {
                for(int c=0; c<W; c++) {
                    matrix[r][c] = sc.nextInt(); 
                }
            }

            minCnt = Integer.MAX_VALUE;
            solve(0);
            System.out.println("#"+tc+" "+minCnt);
        }

    }

    private static void solve(int k) {
        // W중에 N개를 뽑아서 완탐
        if(k == N) {
            calculate();
            count();
            return;
        }
        for(int i=0; i<W; i++) {
            select[k] = i;
            solve(k+1);
        }
    }

	private static void count() {
	    int cnt = 0;
	    for(int r=0; r<H; r++) {
	        for(int c=0; c<W; c++) {
	            if(copyMatrix[r][c] != 0 ) cnt++;
	        }
	    }
	    minCnt = Math.min(minCnt, cnt);
	}
	
	private static void calculate() {
	    for(int r=0; r<H; r++) {
	        for(int c=0; c<W; c++) {
	            copyMatrix[r][c] = matrix[r][c]; 
	        }
	    }
	    
	    for(int i=0; i<N; i++) {
	        throwBall(findTopR(select[i]), select[i]);
	        down();
	    }
	    
	}
	
	
	// 
	private static void down() {
	    for(int c=0; c<W; c++) {
	    	Stack<Integer> st = new Stack<>();
	        for(int r=0; r<H; r++) {
	        	if(copyMatrix[r][c] != 0) st.push(copyMatrix[r][c]);
	        }
	        for(int r=H-1; r>=0; r--) {
	            if(!st.isEmpty()) copyMatrix[r][c] = st.pop();
	            else copyMatrix[r][c] = 0;
	        }
	    }
	}
	
	private static int findTopR(int c) {
	    int topR = H-1;
	    for(int r=0; r<H; r++) {
	        if(copyMatrix[r][c] != 0) {
	            topR = r;
	            break;
	        }
	    }
	    return topR;
	}
	
	private static void throwBall(int r, int c) {
	    int num = copyMatrix[r][c];
	    if(num==0) return;
	    copyMatrix[r][c] = 0;
	    for(int i=1; i<num; i++) {
	        for(int d=0; d<4; d++) {
	            int nr = r + dr[d]*i;
	            int nc = c + dc[d]*i;
	            if(nr<0||nr>=H||nc<0||nc>=W) continue;
	            throwBall(nr, nc);
	        }
	    }
	}
}