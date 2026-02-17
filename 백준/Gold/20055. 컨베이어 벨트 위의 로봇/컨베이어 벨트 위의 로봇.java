import java.util.*;

public class Main {
	static int N;
	static int [] conArr;
	static boolean [] robots;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int K = sc.nextInt();
    	conArr = new int [2*N];
    	for(int i=0; i<2*N; i++) {
    		conArr[i] = sc.nextInt();
    	}
    	
    	
//    	turn();
//    	for(int i=0; i<2*N; i++) {
//    		System.out.println(conArr[i]);
//    	}
    	
    	int ans =0;
    	robots = new boolean [N];
    	while(true) {
    		ans++;
    		turn();
    		move();
    		
    		if(conArr[0]>0) {
    			conArr[0]--;
    			robots[0] = true;
    		} else robots[0] = false;
    		
    		int cnt = 0;
    		for(int i=0; i<2*N; i++) {
        		if(conArr[i]==0) cnt++;
        	}
    		if(cnt >= K) break;
    	}
    	
    	System.out.println(ans);
	}

	private static void move() {
		for(int i=N-2; i>0; i--) {
			if(robots[i] && !robots[i+1] && conArr[i+1]>0) {
				robots[i+1] = true;
				robots[i] = false;
				conArr[i+1]--;
			}
		}
		
		robots[N-1] = false;
	}

	private static void turn() {
		int temp = conArr[2*N-1];
		for(int i=(2*N)-1; i>0; i--) {
			conArr[i] = conArr[i-1];
		}
		conArr[0] = temp;
		
		for(int i=N-1; i>0; i--) {
			robots[i] = robots[i-1];
		}
		robots[N-1] = false;
	}
}