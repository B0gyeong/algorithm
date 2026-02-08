import java.util.*;

public class Main {
	static int N;
	static int M;
	static int [] nums;
	static int [] t;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int [N];
		t = new int [M];
		for(int i=0 ; i<N; i++) {
			nums[i] = i+1;
		}
		
		comb(0,0);
		
	}
	
	private static void comb(int k, int s) {
		if(k == M) {
			for(int i=0; i<M; i++) {
				System.out.print(t[i]+" ");
			}
			System.out.println();
			return;
		} else {
			for(int i=s; i<N; i++) {
				t[k] = nums[i];
				comb(k+1,i+1);
			}
		}
		
	}
}