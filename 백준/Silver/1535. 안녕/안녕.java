import java.util.*;

public class Main {	
	static int N, maxAns;
	static int [] L, J;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = new int [N];
		J = new int [N];
		
		for(int i=0; i<N; i++) {
			L[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			J[i] = sc.nextInt();
		}
		
		maxAns = Integer.MIN_VALUE;
		subset(0, 0, 0);
		System.out.println(maxAns);
	}
    
	private static void subset(int idx, int Lsum, int Jsum) {
		if(Lsum >= 100) return;
		
		maxAns = Math.max(maxAns, Jsum);
		
		if(idx == N) return;
		
		subset(idx+1, Lsum, Jsum);
		subset(idx+1, Lsum + L[idx], Jsum + J[idx]);
	}
}