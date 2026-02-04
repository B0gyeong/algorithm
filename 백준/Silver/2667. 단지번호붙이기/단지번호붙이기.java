import java.util.*;

public class Main {
	public static boolean isHouse(int [][] arr, int row, int col, int N) {
		if(!(0>row || row>=N || 0>col || col>=N) && arr[row][col]==1) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] matrix = new int [N][N];
		boolean [][] visited = new boolean [N][N];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<N; j++) {
				int num = line.charAt(j)-'0';
				matrix[i][j] = num;
			}
		}
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		int cnt = 0;
		ArrayList<Integer> cntList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(matrix[i][j]==1 && !visited[i][j]) {
					int num = 0;
					st.push(i*N+j);
					visited[i][j] = true;
					while(!st.isEmpty()) {
						int top = st.pop();
						num++;
						int nr = top / N;
						int nc = top % N;
						for(int d=0; d<4; d++) {
							int cr = nr+dx[d];
							int cc = nc+dy[d];
							if(isHouse(matrix, cr, cc, N) && !visited[cr][cc]) {
								st.push(cr*N+cc);
								visited[cr][cc] = true;
							}
						}
					}
					cnt++;
					cntList.add(num);
				}
			}
		}
		Collections.sort(cntList);
		System.out.println(cnt);
		for(int i=0; i<cntList.size(); i++) {
			System.out.println(cntList.get(i));
		}
	}
}