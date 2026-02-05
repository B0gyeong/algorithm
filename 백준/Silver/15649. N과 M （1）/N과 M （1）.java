import java.util.*;

public class Main {
	static int N, M;
    static int[] a;  
    static int[] t;     
    static boolean[] visited;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	a = new int[N];
    	for (int i = 0; i < N; i++) a[i] = i + 1;
    	
    	t = new int[M];
        visited = new boolean[N];
        
    	perm(0);
	}

	private static void perm(int k) {
		if(k == M) {
			for (int val : t) System.out.print(val+" ");
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			t[k]= a[i];
			visited[i] = true;
			perm(k+1);
			visited[i] = false;
		}
	}	
}
