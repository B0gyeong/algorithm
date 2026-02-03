import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] switState = new int [N+1];
        for(int i=1; i<=N; i++) {
        	switState[i]= sc.nextInt(); 
        }
        int stuN = sc.nextInt();
        for(int i=0; i<stuN; i++) {
        	int stuS = sc.nextInt();
        	int stuNum = sc.nextInt();
        	
        	if(stuS == 1) {
        		for(int j=1; j<N+1; j++) {
        			if(j%stuNum==0) {
        				switState[j]=(switState[j]+1)%2;
        			}
        		}
        	} else {
        		switState[stuNum]=(switState[stuNum]+1)%2;
        		for(int j=1; j<=Math.min(stuNum-1, N-stuNum);j++) {
        			if(switState[stuNum-j]==switState[stuNum+j]) {
        				switState[stuNum-j]=(switState[stuNum-j]+1)%2;
        				switState[stuNum+j]=(switState[stuNum+j]+1)%2;
        			} else {
        				break;
        			}
        		}
        	}
        	
        }
        for(int i=1; i<=N; i++) {
        	System.out.print(switState[i]+" ");
        	if(i%20==0) {
        		System.out.println();
        	}
        }
    }
}