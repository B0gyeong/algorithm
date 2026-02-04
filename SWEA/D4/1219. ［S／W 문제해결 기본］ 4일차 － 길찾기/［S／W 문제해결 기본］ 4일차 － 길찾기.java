import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        for(int tc=0; tc<10; tc++) {
            int [] g1 = new int [100];
            int [] g2 = new int [100];
            Arrays.fill(g1, -1);
            Arrays.fill(g2, -1);
            
            Stack<Integer> st = new Stack<>();
            boolean [] visited = new boolean [100];
            
            int testcase = sc.nextInt();
            int edgeNum = sc.nextInt();
            
            for(int i=0; i<edgeNum; i++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                
                if(g1[num1]==-1) g1[num1]=num2;
                else g2[num1]=num2;
            }
            
            st.push(0);
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
                
                if(nextNum1 != -1 && !visited[nextNum1]) {
                    st.push(nextNum1);
                    visited[nextNum1] = true;
                }
                if(nextNum2 != -1 && !visited[nextNum2]) {
                    st.push(nextNum2);
                    visited[nextNum2] = true;
                }
                 
            }
            System.out.println("#"+testcase+" "+(find?1:0));
        }
    }
}