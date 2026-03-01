import java.util.*;

public class Main {	
	static int N, minAns;
	static int [] sArr, bArr;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sArr = new int [N];
		bArr = new int [N];
		
		for(int i=0; i<N; i++) {
			sArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
		}
		
		minAns = Integer.MAX_VALUE;
		subset(0, 1, 0);
		System.out.println(minAns);
	}
    
	private static void subset(int k, int sSum, int bSum) {
		if(k == N) {
			if(sSum == 1 && bSum == 0) return;
			
			int diff = Math.abs(sSum - bSum);
			minAns = Math.min(diff, minAns);
			return;
		}
		
		subset(k+1, sSum * sArr[k], bSum + bArr[k]);
		subset(k+1, sSum, bSum);
	}
}