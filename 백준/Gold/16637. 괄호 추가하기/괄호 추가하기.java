import java.util.*;

public class Main {
	static int N;
	static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static int maxAns = Integer.MIN_VALUE;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String formula = sc.next();
		
		for(int i=0; i<N; i++) {
			if (i % 2 == 0) nums.add(formula.charAt(i) - '0');
            else ops.add(formula.charAt(i));
		}
		
		solve(0, nums.get(0));
        System.out.println(maxAns);
	}

	private static void solve(int opIdx, int curSum) {
		if(opIdx >= ops.size()) {
			maxAns = Math.max(maxAns, curSum);
			return;
		}
		
		int res1 = calculate(curSum , ops.get(opIdx), nums.get(opIdx+1));
		solve(opIdx+1, res1);

		if(opIdx+1< ops.size()) {
			int bracketRes = calculate(nums.get(opIdx+1) , ops.get(opIdx+1), nums.get(opIdx+2));
			int res2 = calculate(curSum , ops.get(opIdx), bracketRes);
			solve(opIdx+2, res2);
		}
	}

	private static int calculate(int a, char o, int b) {
		if(o == '+') return a+b;
		if(o == '-') return a-b;
		return a*b;
	}
}