import java.util.*;

public class Main {
	static int N;
	static int S;
	static int cnt;
	static int [] Nums;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	S = sc.nextInt();
    	Nums = new int [N];
    	for(int i=0; i<N; i++) {
    		Nums[i] = sc.nextInt(); 
    	}
    	
    	cnt = 0;
    	dfs(0, 0);
    	if (S == 0) {
    	    System.out.println(cnt - 1);
    	} else {
    	    System.out.println(cnt);
    	}
	}
    
	private static void dfs(int i, int sum) {
		if(i==N) {
			if(sum == S) cnt++;
			return;
		}
		
		dfs(i+1, sum + Nums[i]);
		
		dfs(i+1 , sum);
	}
}

