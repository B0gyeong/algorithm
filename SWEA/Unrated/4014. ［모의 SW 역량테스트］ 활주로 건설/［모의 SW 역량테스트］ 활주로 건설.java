import java.util.*;

public class Solution {
    static int N;
    static int X;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            X = sc.nextInt();
            int ansCnt = 0;
            int [][] rowMatrix = new int [N][N];
            int [][] colMatrix = new int [N][N];
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    rowMatrix[r][c] = sc.nextInt();
                    colMatrix[c][r] = rowMatrix[r][c];
                }
            }
            
            for(int r=0; r<N; r++) {
            	if(check(rowMatrix[r])) ansCnt++;
            	if(check(colMatrix[r])) ansCnt++;
            }
            
            System.out.println("#"+tc+" "+ansCnt);
            
        }
    }

	private static boolean check(int[] line) {
		// TODO Auto-generated method stub
		boolean [] visited = new boolean [N];
		int cnt = 1;
		for(int c=0; c<N-1; c++) {
            if(line[c+1]-line[c] > 1) {
                return false;
            } else if(line[c+1]-line[c] == 1){
                if(cnt >= X) {
                    for(int currC = c; currC > c-X; currC--) {
                        visited[currC] = true;
                    }
                    cnt = 1;
                } else {
                    return false;
                }
            } else {
                cnt++;
            }
        }
		
		cnt = 1;
        for(int c=N-1; c>0; c--) {
        	if(line[c-1]- line[c] > 1)  return false;
        	else if(line[c-1]-line[c] == 1) {
        		if(cnt >= X) {
        			for(int currC = c; currC < c+X; currC++) {
        				if(visited[currC]) {
        					return false;
        				}
        			}
        			cnt = 1;
        		} else return false;
        	} else cnt++;
        }

		return true;
	}
}

