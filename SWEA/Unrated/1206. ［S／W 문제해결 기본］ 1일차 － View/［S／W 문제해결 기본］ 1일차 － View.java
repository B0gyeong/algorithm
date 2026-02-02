import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int [] buildings = new int [N];
			int ans = 0;
			for(int i=0;i<N;i++) {
				buildings[i]= sc.nextInt();
			}
			for(int i=2;i<N-2;i++) {
				int bMax = Math.max(Math.max(buildings[i-1], buildings[i-2]),Math.max(buildings[i+1], buildings[i+2]));
				if(bMax < buildings[i]) {
					ans += (buildings[i]-bMax);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}