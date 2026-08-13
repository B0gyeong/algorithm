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

        double sum = 0.0;
        double minVal = Double.MAX_VALUE;
        int size = 0;
        for(int k=N-1; k>=1; k--){
            sum+=arr[k];
            minVal = Math.min(minVal, arr[k]);
            size++;
            if(size-1 == 0) continue;
            result=Math.max(result, (double) (sum-minVal) / (size-1));
        }

        System.out.printf("%.2f\n", result);


    }
}