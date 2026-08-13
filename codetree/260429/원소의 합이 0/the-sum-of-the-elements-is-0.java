import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] arrs = new int[3][N];
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
            int num = Integer.parseInt(st2.nextToken());
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }

        int sum = 0;
        int result = 0;
        for(int i=0; i<N; i++) {
            sum+=arrs[0][i];
            for(int j=0; j<N; j++) {
                sum+=arrs[1][j];
                for(int s=0; s<N; s++) {
                    sum+=arrs[2][s];
                    int target = -1 * sum;
                    if(hm.containsKey(target)) {
                        result+=hm.get(target);
                    }
                    sum-=arrs[2][s];
                }
                sum-=arrs[1][j];
            }
            sum-=arrs[0][i];
        }

        System.out.println(result);
    }
}