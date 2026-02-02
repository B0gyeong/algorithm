import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int dump = sc.nextInt();
            int[] row = new int[100]; 
            for (int i = 0; i < row.length; i++) {
                row[i] = sc.nextInt();
            }
            for (int d = 0; d < dump; d++) {
                int maxIdx = 0;
                int minIdx = 0;
                for (int i = 1; i < row.length; i++) {
                    if (row[i] > row[maxIdx]) {
                        maxIdx = i;
                    }
                    if (row[i] < row[minIdx]) {
                        minIdx = i;
                    }
                }
                row[maxIdx]--;
                row[minIdx]++;
                if (row[maxIdx] - row[minIdx] <= 1) {
                    break;
                }
            }
            int max = row[0];
            int min = row[0];
            for (int i = 1; i < row.length ; i++) {
                max = Math.max(max, row[i]);
                min = Math.min(min, row[i]);
            }
            System.out.println("#" + tc + " " + (max - min));
        }
    }
}
