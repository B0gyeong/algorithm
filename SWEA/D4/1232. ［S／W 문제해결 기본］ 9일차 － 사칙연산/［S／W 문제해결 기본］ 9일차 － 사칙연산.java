import java.util.*;

public class Solution {
	static int [][] tree;
	static String [] value;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	for(int tc=1; tc<=10; tc++) {
    		int N = sc.nextInt();
    		sc.nextLine();
    		tree = new int [N+1][2];
    		value = new String [N+1];
    		for(int i=1; i<=N; i++) {
    			String s = sc.nextLine();
    			String [] sArr = s.split(" ");
    			if(!isNumeric(sArr[1])) {
    				tree[i][0] = Integer.parseInt(sArr[2]);
    				tree[i][1] = Integer.parseInt(sArr[3]);
    			}
    			value[i] = sArr[1];
    		}
    		
    		int ans = (int) calculate(1);
    		System.out.println("#"+tc+" "+ans);
		}
	}
	private static double calculate(int v) {
		if (isNumeric(value[v])) {
	        return Double.parseDouble(value[v]);
	    }

	    double left = calculate(tree[v][0]);
	    double right = calculate(tree[v][1]);

	    if (value[v].equals("+")) return left + right;
	    if (value[v].equals("-")) return left - right;
	    if (value[v].equals("*")) return left * right;
	    return left / right;

	}
	
	public static boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
