import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> m = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();

            if(m.containsKey(s)) {
                m.put(s, m.get(s)+1);
            } else {
                m.put(s, 1);
            }
        }

        System.out.println(Collections.max(m.values()));
    }
}