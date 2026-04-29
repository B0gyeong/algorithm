import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            char [] c= str.toCharArray();
            Arrays.sort(c);
            String strF = new String(c);
            if(hm.containsKey(strF)) {
                hm.put(strF, hm.get(strF)+1);
            } else {
                hm.put(strF, 1);
            }
        }

        System.out.println(Collections.max(hm.values()));
    }
}
