import java.util.*;

public class Main {
	static int N;
	static char [] opers;
	static char [] t;
	static int maxValue;
	static int minValue;
	static int [] nums;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int [N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		int operPlus = sc.nextInt();
		int operS = sc.nextInt();
		int operProduct = sc.nextInt();
		int operD = sc.nextInt();
		opers = new char[N - 1];
		int idx = 0;
		for (int i = 0; i < operPlus; i++) opers[idx++] = '+';
		for (int i = 0; i < operS; i++) opers[idx++] = '-';
		for (int i = 0; i < operProduct; i++) opers[idx++] = '*';
		for (int i = 0; i < operD; i++) opers[idx++] = '/';
		
		maxValue = Integer.MIN_VALUE;
		minValue = Integer.MAX_VALUE;
		
		t = new char[N - 1];
		visited = new boolean [N-1];
		
		perm(0);
		
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void perm(int k) {
		if (k == N - 1) {
            int result = nums[0];
            for (int i = 0; i < N - 1; i++) {
                result = calcul(result, nums[i + 1], t[i]);
            }
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                t[k] = opers[i];
                perm(k + 1);
                visited[i] = false; // 백트래킹 복구
            }
        }
    }

	private static int calcul(int i, int j,char c) {
		if(c == '*') return i*j;
		else if (c == '+') return i+j;
		else if (c == '-') return i-j;
		else return i/j;
	}
}