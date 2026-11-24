import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sList = br.readLine().split(" ");

        int H = Integer.parseInt(sList[0]);
        int W = Integer.parseInt(sList[1]);
        int N = Integer.parseInt(sList[2]);
        int M = Integer.parseInt(sList[3]);

        int rNum = H/(N+1);
        if(H%(N+1) > 0) rNum++;
        int cNum = W/(M+1);
        if(W%(M+1) > 0) cNum++;

        System.out.println(rNum * cNum);
    }
}


