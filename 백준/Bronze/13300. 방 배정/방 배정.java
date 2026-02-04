import java.util.*;
public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double K = sc.nextInt();
        int [] stuW = new int [7];
        int [] stuM = new int [7];
        int ans = 0;
        for(int i=0; i<N; i++) {
        	int stuS = sc.nextInt();
        	int stuG = sc.nextInt();
        	if(stuS==1) {
        		stuM[stuG]++;
        	} else {
        		stuW[stuG]++;
        	}
        }
        for(int i=1; i<7; i++) {
        	if(stuW[i]!=0) {
        		ans += Math.ceil(stuW[i]/K);
        	}
        	if(stuM[i]!=0) {
        		ans += Math.ceil(stuM[i]/K);
        	}
        }
        System.out.println(ans);
    }
}