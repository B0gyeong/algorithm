import java.util.*;

public class Solution {
	private static boolean isWall(int nRow, int nCol, int[][] matrix) {
		if(nRow<0 || nRow>=16 || nCol<0 || nCol>=16 || matrix[nRow][nCol]==1) {
			return true;
		}
		return false;
	}	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=0; tc<10; tc++) {
        	int testcase = sc.nextInt();
        	int [][] matrix = new int [16][16];
        	boolean [][] visited = new boolean [16][16];
        	Stack<Integer> st = new Stack<>();
        	int sRow = 0, sCol = 0;
        	for(int row=0; row<16; row++) {
        		String line = sc.next();
        		for(int col=0; col<16; col++) {
        			int num = line.charAt(col) - '0';
        			matrix[row][col] = num; 
        			if (num == 2) {
        				sRow = row;
        				sCol = col;
        				st.push(sRow * 16 + sCol);
        				visited[sRow][sCol] = true;
        			}
        		}
        	}
        	int [] dx = {-1,1,0,0};
        	int [] dy = {0,0,-1,1};
        	boolean find = false;
        	while(!st.isEmpty()) {
        		int cur = st.pop();
        		int r = cur / 16, c = cur % 16;
        		if(matrix[r][c]==3) {
        			find = true;
        			break;
        		}
        		for(int d=0; d<4; d++) {
        			int nr = r+dx[d];
        			int nc = c+dy[d];
        			if(!isWall(nr,nc,matrix) && !visited[nr][nc]) {
        				st.push(nr * 16 + nc);
            			visited[nr][nc] = true;
            		}
        		}
        	}
        	if(find) {
        		System.out.println("#"+testcase+" "+1);
        	} else {
        		System.out.println("#"+testcase+" "+0);
        	}
        }
    }

	
}