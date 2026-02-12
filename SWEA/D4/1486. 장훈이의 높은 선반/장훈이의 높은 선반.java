import java.util.*;

public class Solution {
	static int N;
	static int B;
	static int minVal;
	static int [] members;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	B = sc.nextInt();
        	members = new int [N];
        	for(int i=0; i<N; i++) {
        		members[i] = sc.nextInt();
        	}
        	
        	minVal = Integer.MAX_VALUE;
        	select(0, 0);
        	System.out.println("#"+tc+" "+minVal);
        	
    	}
	}
    
	private static void select(int idx, int sum) {
		if(idx == N) {
			if(sum < B) return;
			minVal = Math.min(minVal, sum-B);
			return;
		}
		
		//고르는 경우
		select(idx+1, sum + members[idx]);
		
		//고르지 않는 경우 
		select(idx+1, sum);
	}
}