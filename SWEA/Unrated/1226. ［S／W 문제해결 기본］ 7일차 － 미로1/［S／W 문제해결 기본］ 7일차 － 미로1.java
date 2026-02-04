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
        	Stack<Integer> stackRow = new Stack<>();
        	Stack<Integer> stackCol = new Stack<>();
        	int sRow = 0;
        	int sCol = 0;
        	for(int row=0; row<16; row++) {
        		String line = sc.next();
        		for(int col=0; col<16; col++) {
        			int num = line.charAt(col) - '0';
        			matrix[row][col] = num; 
        			if (num == 2) {
        				sRow = row;
        				stackRow.push(sRow);
        				sCol = col;
        				stackCol.push(sCol);
        				visited[sRow][sCol] = true;
        			}
        		}
        	}
        	int nRow = 0;
        	int nCol = 0;
        	int [] dx = {-1,1,0,0};
        	int [] dy = {0,0,-1,1};
        	boolean find = false;
        	while(!stackRow.isEmpty()) {
        		nRow = stackRow.pop();
        		nCol = stackCol.pop();
        		if(matrix[nRow][nCol]==3) {
        			find = true;
        			break;
        		}
        		for(int d=0; d<4; d++) {
        			int curRow = nRow+dx[d];
        			int curCol = nCol+dy[d];
        			if(!isWall(curRow,curCol,matrix) && !visited[curRow][curCol]) {
            			stackRow.push(curRow);
            			stackCol.push(curCol);
            			visited[curRow][curCol] = true;
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