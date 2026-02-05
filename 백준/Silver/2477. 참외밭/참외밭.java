import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int K = sc.nextInt(); 
        int[][] edges = new int[6][2]; 
        
        int maxW = 0, maxH = 0; 
        int maxWIdx = 0, maxHIdx = 0; 

        for (int i = 0; i < 6; i++) {
            edges[i][0] = sc.nextInt(); 
            edges[i][1] = sc.nextInt(); 
            
            
            if (edges[i][0] == 1 || edges[i][0] == 2) {
                if (edges[i][1] > maxW) {
                    maxW = edges[i][1];
                    maxWIdx = i;
                }
            }
            
            else {
                if (edges[i][1] > maxH) {
                    maxH = edges[i][1];
                    maxHIdx = i;
                }
            }
        }
        
        int totalArea = maxW * maxH;

        // 가장 긴 변의 양옆에 붙어있는 변들의 차이가 빈 사각형의 변의 길이
        // (i+1) % 6 과 (i+5) % 6은 현재 인덱스의 앞뒤 인덱스를 의미
        int smallW = Math.abs(edges[(maxHIdx + 5) % 6][1] - edges[(maxHIdx + 1) % 6][1]);
        int smallH = Math.abs(edges[(maxWIdx + 5) % 6][1] - edges[(maxWIdx + 1) % 6][1]);
        
        int smallArea = smallW * smallH;
        
        System.out.println((totalArea - smallArea) * K);
    	
    }	
}
