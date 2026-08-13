import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maxVal) maxVal = arr[i];
        }

        int k = String.valueOf(maxVal).length();
        arr = radixSort(arr, k);

        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int [] radixSort(int[] arr, int k){
        int n = arr.length;
        int dev = 1;

        for(int pos=0; pos<k; pos++){
            ArrayList<Integer>[] bucket = new ArrayList[10];
            for(int i=0; i<10; i++){
                bucket[i] = new ArrayList<>();
            }

            for(int i=0; i<n; i++){
                int digit = (arr[i] / dev) % 10;
                bucket[digit].add(arr[i]);
            }

            int index = 0;
            for(int i=0; i<10; i++){
                for(int val : bucket[i]){
                    arr[index++] = val;
                }
            }

            dev *= 10;
        }
        return arr;
    }
}