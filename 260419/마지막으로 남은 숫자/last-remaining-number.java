import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(-1 * Integer.parseInt(st.nextToken()));
        }

        while(pq.size() >= 2){
            int a = -1 * pq.poll();
            int b = -1 * pq.poll();
            int diff = Math.abs(a - b);
            if(diff != 0) {
                pq.add(-1 * diff);
            }
        }

        System.out.println(pq.isEmpty() ? -1: (-1*pq.poll()));
    }
}