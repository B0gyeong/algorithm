import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int a=1; a<=T; a++) {
			int tc = sc.nextInt();
			int [] stu = new int [1000];
            int [] score = new int [101];
			for(int i=0; i<stu.length; i++) {
				stu[i]= sc.nextInt(); 
                score[stu[i]] += 1; 
			}
			int maxIdx = 0;
			for(int i=1; i<score.length; i++) {
				if(score[maxIdx] <= score[i]) {
					maxIdx = i;
				}
			}
			System.out.println("#"+tc+" "+maxIdx);
		}
	}
}