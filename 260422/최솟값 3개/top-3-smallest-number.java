import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);

            if(i > 1){
                if(max == Integer.MAX_VALUE || max > num) {
                    int a = pq.poll();
                    int b = pq.poll();
                    int c = pq.poll();
                    max = c;
                    result = a*b*c;
                    pq.add(a);
                    pq.add(b);
                    pq.add(c);
                } 
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }
    }
}