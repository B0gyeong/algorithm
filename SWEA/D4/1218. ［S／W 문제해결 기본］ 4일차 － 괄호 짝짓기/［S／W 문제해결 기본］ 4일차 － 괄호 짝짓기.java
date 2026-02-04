import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
        	int ans = -1;
        	int L = sc.nextInt();
        	String S = sc.next();
        	char ary[] = S.toCharArray();
        	Stack<Character> st = new Stack<>();
        	for(int i=0; i<L; i++) {
        		char c = ary[i];
        		if(c=='(' || c=='{' || c=='[' || c=='<') {
        			st.push(c);
        		} else if(c==')') {
        			if(st.isEmpty()) {
        				ans = 0;
        				break;
        			}
        			char closeC = st.pop();
        			if(closeC == '(') {
        				ans = 1;
        			} else {
        				ans = 0;
        				break;
					}
        		} else if(c=='}') {
        			if(st.isEmpty()) {
        				ans = 0;
        				break;
        			}
        			char closeC = st.pop();
        			if(closeC == '{') {
        				ans = 1;
        			} else {
        				ans = 0;
        				break;
					}
        		} else if(c==']') {
        			if(st.isEmpty()) {
        				ans = 0;
        				break;
        			}
        			char closeC = st.pop();
        			if(closeC == '[') {
        				ans = 1;
        			} else {
        				ans = 0;
        				break;
					}
        		} else {
        			if(st.isEmpty()) {
        				ans = 0;
        				break;
        			}
        			char closeC = st.pop();
        			if(closeC == '<') {
        				ans = 1;
        			} else {
        				ans = 0;
        				break;
					}
        		}
        	}
        	System.out.println("#"+tc+" "+ans);
        }
    }
}