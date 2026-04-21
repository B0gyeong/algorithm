import java.io.*;
import java.util.*;

public class Main {
    static int result, N, M, K;
    static int [] arrN, arrM;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arrN = new int [N];
        for(int i=0; i<N; i++) {
            arrN[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arrN);
        
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        arrM = new int [M];
        for(int i=0; i<M; i++) {
            arrM[i] = Integer.parseInt(st3.nextToken());
        }
        Arrays.sort(arrM);

        result = 0;
        solution(arrN[0]+arrM[0], arrN[N-1]+arrM[M-1]);

        System.out.println(result);

        
    }

    public static void solution(int low, int high) {
        if(low > high) return;
        int X = (low + high) / 2;
        int j = M-1;
        int c = 0;
        for(int i=0; i<N; i++){
            while(j>=0 && arrN[i]+arrM[j] > X){
                j--;
            }

            if(j >=0){
                c+= j+1;
            }
        }

        if (c <= K) {
            result = X;
            solution(X+1, high);
        } else {
            solution(low, X-1);
        }
    }
}