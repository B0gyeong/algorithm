import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(hm.containsKey(x)) {
                if(hm.get(x) > y) {
                    hm.put(x, y);
                } 
            } else {
                hm.put(x, y);
            }
        }

        int sum = 0;
        for(int num : hm.values()) {
            sum+=num;
        }

        System.out.println(sum);
    }
}