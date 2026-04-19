import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] arr = new int [N];
        for(int i=0; i<N; i++){
            pq.add( -1 * Integer.parseInt(st2.nextToken()));
        }

        for(int i=0; i<M; i++){
            pq.add(pq.poll() +1);
        }

        System.out.println(-1 * pq.poll());

    }
}