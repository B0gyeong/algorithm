import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double result = Double.MIN_VALUE;
        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=1; k<=N-2; k++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=k; i<N; i++){
                pq.add(arr[i]);
            }

            pq.poll();
            int sum = 0;
            double size = pq.size();
            while(!pq.isEmpty()){
                sum+=pq.poll();
            }
            result = Math.max(result, (double) sum/size);
        }

        System.out.printf("%.2f\n", result);


    }
}