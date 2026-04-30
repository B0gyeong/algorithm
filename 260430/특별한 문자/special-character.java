import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char [] chars = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char c = chars[i];
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c)+1);
            } else {
                hm.put(c, 1);
            }
        }

        boolean find = false;
        for(char c : chars) {
            if(hm.get(c) == 1) {
                System.out.println(c);
                find = true;
                break;
            }
        }

        if(!find) System.out.println("None");
    }
}