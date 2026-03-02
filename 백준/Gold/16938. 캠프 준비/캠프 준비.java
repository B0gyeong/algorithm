import java.util.*;

public class Main {	
	static int N, L, R, X, cnt;
	static int [] levels;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        L = sc.nextInt();   R = sc.nextInt();
        X = sc.nextInt();
        
        levels = new int [N];
        for(int i=0; i<N; i++) {
        	levels[i] = sc.nextInt();
        }
        
        cnt = 0;
        subset(0, 0, Integer.MAX_VALUE, 0);
        System.out.println(cnt);
        
	}
    
	private static void subset(int idx, int sum, int lower, int higher) {
		if(R < sum) return; // 이미 sum이 R보다 커졌으면 더이상 작아질 수 없으므로 가지치기  
		
		if(idx == N) {
			if(higher - lower < X || sum < L) return; // 조건 확인 
			
			cnt++;
			return;
		}
		
		// 선택 안함 
		subset(idx+1, sum, lower, higher);
		subset(idx+1, sum+levels[idx], Math.min(lower, levels[idx]), Math.max(higher, levels[idx]));
		
	}
}