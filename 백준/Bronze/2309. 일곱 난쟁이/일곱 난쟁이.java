import java.util.*;
public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int [] h = new int [9];
    	int sum = 0;
    	for(int i=0; i<9; i++) {
    		h[i] = sc.nextInt();
    		sum += h[i];
    	}
    	Arrays.sort(h);
    	int fake1 = -1, fake2 = -1;
    	for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - h[i] - h[j] == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != -1) break; // 가짜를 찾았으면 탈출
        }
    	for (int i = 0; i < 9; i++) {
            if (i == fake1 || i == fake2) continue;
            System.out.println(h[i]);
        }
    }
}
