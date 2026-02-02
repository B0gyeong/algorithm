import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean [][] matrix = new boolean[101][101];
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			for(int x=x1; x<x1+10; x++) {
				for(int y=y1; y<y1+10; y++) {
					if(!matrix[x][y]) {
						matrix[x][y] = true;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
