import java.util.*;

public class Main {
	static int N;
    static int[] a;  
    static int[] t;     
    static boolean[] visited;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	a = new int [N];
    	t = new int [N];
    	visited = new boolean [N];
    	for(int i=0; i<N; i++) a[i] = i+1;
    	
    	perm(0);
	}

	private static void perm(int k) {
		if(k==N) {
			for(int val : t) System.out.print(val+" ");
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			t[k] = a[i];
			visited[i] = true;
			perm(k+1);
			visited[i] = false;
		}
	}	
}
