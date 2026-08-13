import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st2.nextToken());
            arr[i] = num;
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }

        int result = 0;
        for(int num : arr) {
            int tnum = K - num;
            if(hm.containsKey(tnum)) {
                result += hm.get(tnum);
                if(num == tnum) result--;
            }
        }

        System.out.println(result/2);
    }
}