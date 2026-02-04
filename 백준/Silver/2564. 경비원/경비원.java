import java.util.*;
public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int w = sc.nextInt();
    	int h = sc.nextInt();
    	int L = 2*(w+h);
    	int storeNum = sc.nextInt();
    	int [] distArr = new int [storeNum+1]; 
    	for(int i=0; i<=storeNum; i++) {
    		int d = sc.nextInt();
    		int dist = sc.nextInt();
    		if(d == 1) {
    			distArr[i] = 2*h + w + (w-dist);
    		} else if(d == 2) {
    			distArr[i] = h + dist;
    		} else if(d == 3) {
    			distArr[i] = dist;
    		} else {
    			distArr[i] = h + w + (h-dist);
    		}
    	}
    	int minDist = 0;
    	for(int i=0; i<storeNum; i++) {
    		int dist1 = Math.abs(distArr[storeNum] - distArr[i]);
    		int dist2 = L - dist1;
    		minDist += Math.min(dist1, dist2);
    	}
    	System.out.println(minDist);
    }
}
