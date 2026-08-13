import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Long> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if(hm.containsKey(x)) {
                if(hm.get(x) > y) {
                    hm.put(x, y);
                } 
            } else {
                hm.put(x, y);
            }
        }

        long sum = 0;
        for(long num : hm.values()) {
            sum+=num;
        }

        System.out.println(sum);
    }
}