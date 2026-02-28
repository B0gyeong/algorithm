import java.util.*;

public class Solution {
	static int N, M, C, powSum, max;
	static int [] list, calList;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	C = sc.nextInt();
        	list = new int [N*N];
        	calList = new int [N*N];
        	for(int i=0; i<N*N; i++) {
        		list[i] = sc.nextInt();
        	}
        	
        	for(int i=0; i<N*N; i++) {
        		if(i%N+M <= N) {
        			calList[i] = calculate(i);
        		}
        	}
        	
        	max = Integer.MIN_VALUE;
        	for(int i=0; i<N*N; i++) {
        		if (calList[i] == 0) continue;
        		
        		for(int j=i+1; j<N*N; j++) {
        			if (calList[j] == 0) continue;
        			
        			if(isNotOverlapped(i,j)) {
        				max = Math.max(max, calList[i] + calList[j]);
        			}
        		}
        	}
        	
        	System.out.println("#"+tc+" "+max);
        }
        
	}
	private static boolean isNotOverlapped(int i, int j) {
		int r1 = i / N;
		int r2 = j / N;
		if(r1 != r2) return true;

		return i+M <= j;
	}
	
	private static int calculate(int i) {
		// TODO Auto-generated method stub
		powSum = Integer.MIN_VALUE;
		
		subset(i, 0, 0, i+M);
		
		return powSum;
	}
	
	private static void subset(int idx, int sum, int powSumF, int F) {
		if(sum > C) {
			return;
		}
		
		if (powSumF > powSum) {
	        powSum = powSumF;
	    }

	    if (idx == F) return;
		
		subset(idx+1, sum+list[idx], powSumF+list[idx]*list[idx], F);
		subset(idx+1, sum, powSumF, F);
	} 
}