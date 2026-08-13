import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> sim = new HashMap<>();
        HashMap<Integer, String> ism = new HashMap<>();

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            sim.put(s, i);
            ism.put(i, s);
        }

        for(int i=1; i<=M; i++) {
            String ans = br.readLine();
            if(Character.isDigit(ans.charAt(0))) {
                System.out.println(ism.get(Integer.parseInt(ans)));
            } else {
                System.out.println(sim.get(ans));
            }
        }
    }
}