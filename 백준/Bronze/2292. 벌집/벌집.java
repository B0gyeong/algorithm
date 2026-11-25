import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        if(target == 1) {
            System.out.println(1);
            return;
        }

        int idx = 1;
        int n = 2;
        while(true) {
            if(target >= n) {
                n += 6 * idx;
                idx++;
            } else {
                break;
            }
        }

        System.out.println(idx);
        
    }
}


