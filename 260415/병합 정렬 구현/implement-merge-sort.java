import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    static int n;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        margeSort(arr, 0, arr.length-1);

        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void margeSort(int [] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            margeSort(arr, low, mid);
            margeSort(arr, mid+1, high);
            marge(arr, low, mid, high);
        }
    }

    public static void marge(int [] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = low;

        int [] margeArr = new int [n];

        while(i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                margeArr[k++] = arr[i++];
            } else {
                margeArr[k++] = arr[j++];
            }
        }

        while(i<=mid){
            margeArr[k++] = arr[i++];
        }

        while(j<=high){
            margeArr[k++] = arr[j++];
        }

        for(int a = low; a<=high; a++){
            arr[a] = margeArr[a];
        }
        
    }
}