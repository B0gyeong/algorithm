import java.util.*;

public class Main {
	static int N;
	static int maxMoney;
	static int [] workDay;
	static int [] money;
	static boolean [] visited;
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	workDay = new int [N];
    	money = new int [N];
    	visited = new boolean [N];
    	for(int i=0; i<N; i++) {
    		workDay[i] = sc.nextInt();
    		money[i] = sc.nextInt();
    	}
    	
    	maxMoney = Integer.MIN_VALUE;
    	dfs(0, 0);
    	System.out.println(maxMoney);
	}
    
	private static void dfs(int day, int sum) {
		if(day >= N) {
			maxMoney = Math.max(maxMoney, sum);
			return;
		}
		
		// 상담하기로 선택하는 경우
		if(day + workDay[day] < N+1) {
			dfs(day + workDay[day], sum+money[day]);
		}
		// 상담을 하지 않는 경우
		dfs(day+1, sum);
	}

}
