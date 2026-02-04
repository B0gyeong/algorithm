import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        	for(int tc=0; tc<10; tc++) {
        		int [] g1 = new int [100];
        		int [] g2 = new int [100];
        		Stack<Integer> st = new Stack<>();
        		boolean [] visited = new boolean [100];
        		int testcase = sc.nextInt();
        		int edgeNum = sc.nextInt();
        		for(int i=0; i<edgeNum; i++) {
        			int num1 = sc.nextInt();
        			int num2 = sc.nextInt();
        			if(g1[num1]==0) {
        				g1[num1]=num2;
        			}else {
        				g2[num1]=num2;
        			}
        		}
        		st.push(g1[0]);
        		visited[0] = true;
        		boolean find = false;
        		while (!st.isEmpty()) {
					int curNode = st.pop();
					if(curNode == 99) {
						find = true;
						break;
					}
					int nextNum1 = g1[curNode];
					int nextNum2 = g2[curNode];
					if(!visited[nextNum1]) {
						st.push(nextNum1);
						visited[nextNum1] = true;
					}
					if(!visited[nextNum2]) {
						st.push(nextNum2);
						visited[nextNum2] = true;
					}
					
				}
        		if(find) {
        			System.out.println("#"+testcase+" "+1);
        		} else {
        			System.out.println("#"+testcase+" "+0);
        		}
        	}
    }
}