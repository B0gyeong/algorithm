import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] matrix = new int[1001][1001];
		for(int row=0; row<1001; row++) {
			for(int col=0; col<1001; col++) {
				matrix[row][col]=0; 
			}
		}
		int N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int x=x1; x<x1+w; x++) {
				for(int y=y1; y<y1+h; y++) {
					matrix[x][y]=i; 
				}
			}
		}
		for(int i=1; i<=N; i++) {
			int ans = 0;
			for(int row=0; row<1001; row++) {
				for(int col=0; col<1001; col++) {
					if(matrix[row][col]==i) {
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
