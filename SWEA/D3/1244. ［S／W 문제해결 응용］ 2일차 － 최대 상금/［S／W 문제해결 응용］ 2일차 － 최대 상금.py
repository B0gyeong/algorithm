import java.util.*;
 
public class Solution {
	static int N, L, maxNum;
	static int [] nums;
	static boolean [][] visited;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		String str = sc.next();
    		L = str.length();
    		nums = new int [L];
    		for(int i=0; i<L; i++) {
    			nums[i] = str.charAt(i)-'0';
    		}
    		N = sc.nextInt();
    		
    		visited = new boolean [N][1000000];
    		maxNum = Integer.MIN_VALUE;
    		perm(0);
    		System.out.println("#"+tc+" "+maxNum);
    		
    		
    	}
	}
    
	private static void perm(int idx) {
		if (idx == N) {
			int num = toNum();
			maxNum = Math.max(maxNum, num);
			return;
		}
		
		if(visited[idx][toNum()]) return;
		
		visited[idx][toNum()] = true;
		
		for(int i=0; i<L-1; i++) {
			for(int j=i+1; j<L; j++) {
				swap(i, j);
				perm(idx+1);
				swap(j, i);
			}
		}
	}

	private static int toNum() {
		int num = 0;
		int j = 0;
		for(int i=L-1; i>=0; i--) {
			num += nums[i] * (Math.pow(10, j));
			j++;
		}
		return num;
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}