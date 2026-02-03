import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [] temps = new int [N];
		for(int i=0; i<N; i++) {
			temps[i] = sc.nextInt();
		}
		int num = 0;
		for(int i=0; i<K; i++) {
			num += temps[i];
		}
		int max = num;
		for(int i=K; i<N;  i++) {
			num += temps[i];
			num -= temps[i-K];
			max = Math.max(max, num);
		}
		System.out.println(max);
	}
}