import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");

        int N = Integer.parseInt(s1Arr[0]);
        int X = Integer.parseInt(s1Arr[1]);

        int[] arrVisit = new int[N];
        for(int i=0; i<N; i++) {
            arrVisit[i] = Integer.parseInt(s2Arr[i]);
        }

        int sum = 0;
        for(int j=0; j<X; j++) {
            sum+=arrVisit[j];
        }
        int maxSum = sum;
        int cnt = 1;

        for(int i=0; i< N-X; i++) {
            sum-= arrVisit[i];
            sum+= arrVisit[i+X];
            
            if(maxSum < sum) {
                maxSum = sum;
                cnt = 1;
            } else if(maxSum == sum) {
                cnt++;
            } 
        }
        
        if(maxSum == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(maxSum);
        System.out.println(cnt);

    }
}






