import java.util.*;

public class Solution {
	static int N, L, maxScore;
	static int [] score, cal;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		N = sc.nextInt();
    		L = sc.nextInt();
    		
    		score = new int [N];
    		cal = new int [N];
    		for(int i=0; i<N; i++) {
    			score[i] = sc.nextInt();
    			cal[i] = sc.nextInt();
    		}
    		
    		maxScore = 0;
    		subset(0, 0, 0);
    		System.out.println("#"+tc+" "+maxScore);
    	}
	}
    
	private static void subset(int idx, int Ssum, int Csum) {
		if(Csum > L) return;
		if(idx == N) {
			maxScore = Math.max(Ssum, maxScore);
			return;
		}
		
		// 재료를 선택할 때 
		subset(idx+1, Ssum+score[idx], Csum+cal[idx]);
		subset(idx+1, Ssum, Csum);
	}
}