import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc=1; tc<=10; tc++) {
        	int L = sc.nextInt();
        	String S = sc.next();
        	char ary[] = S.toCharArray();
        	
        	Stack<Character> st = new Stack<>();
        	int ans = 1;
        	
        	for(int i=0; i<L; i++) {
        		char c = ary[i];
        		
        		if(c=='(' || c=='{' || c=='[' || c=='<') {
        			st.push(c);
        		} else {
        			if(st.isEmpty()) {
        				ans = 0;
        				break;
        			}
        			char top = st.pop();
        			if(!((top == '(' && c == ')') ||
                            (top == '{' && c == '}') ||
                            (top == '[' && c == ']') ||
                            (top == '<' && c == '>'))) {
        				ans = 0;
        				break;
        			}
        		}
        	}
        	if(!st.isEmpty()) ans = 0;

        	System.out.println("#"+tc+" "+ans);
        }
    }
}