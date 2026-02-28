import java.util.*;

public class Solution {
	static int N, maxH, cntDayMin, twoCnt, oneCnt;
	static int [] trees;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	
        	trees = new int [N];
        	twoCnt = 0; oneCnt = 0;
        	maxH = 0;
        	for(int i=0; i<N; i++) {
        		trees[i] = sc.nextInt();
        		if(trees[i] > maxH) maxH = trees[i];
        	}
        	
        	for(int i=0; i<N; i++) {
        		int dif = maxH - trees[i];
        		twoCnt += dif / 2;
        		oneCnt += dif % 2;
        	}
        	
        	while(twoCnt - oneCnt > 1) {
        		twoCnt--;
        		oneCnt += 2;
        	}
        	
        	if(twoCnt >= oneCnt) {
        		cntDayMin = twoCnt*2;
        	} else {
        		cntDayMin = oneCnt*2 - 1;
        	}

        	System.out.println("#"+tc+" "+cntDayMin);
        }
	}

}