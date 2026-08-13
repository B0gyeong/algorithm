import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){ 
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if(str.equals("push")){
                int n1 = Integer.parseInt(st.nextToken());
                pq.add(-1 * n1);
            } else if(str.equals("pop")) {
                System.out.println(-1 * pq.poll());
            } else if(str.equals("size")) {
                System.out.println(pq.size());
            } else if(str.equals("empty")) {
                System.out.println(pq.isEmpty() ? 1:0);
            } else {
                System.out.println(-1 * pq.peek());
            }
        }
    }
}