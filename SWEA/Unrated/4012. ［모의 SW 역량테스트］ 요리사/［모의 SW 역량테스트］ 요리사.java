import java.util.*;

public class Solution {
	static int N;
	static int minVal;
	static boolean [] visited;
	static int [][] matrix;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		N = sc.nextInt();
    		matrix = new int [N][N];
    		for(int r=0; r<N; r++) {
    			for(int c=0; c<N; c++) {
    				matrix[r][c] = sc.nextInt();
    			}
    		}
    		
    		
    		visited = new boolean [N];
    		minVal = Integer.MAX_VALUE;
    		solve(0, 0);
    		System.out.println("#"+tc+" "+minVal);
    	}
	    
	}

	private static void solve(int k, int s) {
		// N개 중에 N/2개를 뽑는 조합
		// 뽑히지 않는 조합도 확인해야되기 때문에 boolean 배열 이용
		if(k == N/2) {
			minVal = Math.min(minVal, calculate());
			return;
		}
		
		for(int i=s; i<N; i++) {
			visited[i] = true;
			solve(k+1, i+1);
			visited[i] = false;
		}
	}

	private static int calculate() {
		// 두개의 배열을 생성하고 각각의 시너지 합을 계산
		// 각 합의 차를 return
		List<Integer> foodA = new ArrayList<>();
		List<Integer> foodB = new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(visited[i]) foodA.add(i);
			else foodB.add(i);
		}
		
		int sumA = 0; int sumB = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i+1; j<N/2; j++) {
				sumA+=matrix[foodA.get(i)][foodA.get(j)];
				sumA+=matrix[foodA.get(j)][foodA.get(i)];
				sumB+=matrix[foodB.get(i)][foodB.get(j)];
				sumB+=matrix[foodB.get(j)][foodB.get(i)];
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}

