import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int arr[] = new int [N];
    	for(int i=1; i<=N; i++) {
    		int num = sc.nextInt();
    		if(arr[N-num-1]==0) {
    			arr[N-num-1] = i;
    		} else {
    			for(int j=N-i; j<N-num-1; j++) {
    				arr[j] = arr[j+1]; 
    			}
    			arr[N-num-1] = i;
    		}
    	}
    	for(int num : arr) {
    		System.out.print(num+" ");
    	}
    }	
}
