import java.util.*;
import java.io.*;

public class Main {
    static int result, K, check, N;
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());

        arr = new int [N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        result = 0;
        check = 0;
        dfs(0, 0);
        System.out.println(result);
        
    }

    public static void dfs(int cnt, int start) {
        if(cnt == 3) {
            if(check == K) result++;
            return;
        }

        for(int i=start; i<N; i++) {
            check+=arr[i];
            dfs(cnt+1, i+1);
            check-=arr[i];
        }



    }


}