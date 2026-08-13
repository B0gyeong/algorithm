import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if(m.containsKey(num)) {
                m.put(num, m.get(num)+1);
            } else {
                m.put(num, 1);
            }
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st3.nextToken());
            if(m.containsKey(num)) {
                System.out.print(m.get(num) + " ");
            } else {
                System.out.print("0 ");
            }
        }
        
    }
}