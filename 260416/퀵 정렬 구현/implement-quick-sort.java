import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n-1);

        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static int partition(int [] arr, int low, int high){
        int pivot = arr[high];
        int k = low-1;

        for(int i=low; i<high; i++) {
            if(arr[i] < pivot) {
                k+=1;
                swap(k, i); // rngus
            }
        }

        swap(k+1, high);
        return k+1;

    }

    public static void quickSort(int [] arr, int low, int high){
        if (low < high){
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos-1);
            quickSort(arr, pos+1, high);
        }
    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}