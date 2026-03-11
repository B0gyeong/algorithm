import java.util.*;

public class Solution {
	static int K;
	static int [][] magnets, turns;
	static boolean [] visited;
	static List<TurnNode> turnList;
	static class TurnNode {
		int num, dir;
		TurnNode(int num, int dir){
			this.num = num; this.dir = dir;
		}
	}
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	K = sc.nextInt();
        	
        	magnets = new int [5][8];
        	for(int r=1; r<=4; r++) {
        		for(int c=0; c<8; c++) {
        			magnets[r][c] = sc.nextInt();
        		}
        	}
        	
        	turns = new int [K][2];
        	for(int i=0; i<K; i++) {
        		turns[i][0] = sc.nextInt();
        		turns[i][1] = sc.nextInt();
        	}
        	
        	for(int i=0; i<K; i++) {
        		visited = new boolean [5];
        		turnList = new ArrayList<>();
        		turnMagnet(turns[i][0], turns[i][1]);
        		
        		for(TurnNode m : turnList) {
        			turnF(m.num, m.dir);
        		}
        	}
        	
        	int sum = 0;
        	for(int i=1; i<=4; i++) {
        		if(magnets[i][0] == 1) {
        			if(i==1) sum += 1;
        			else if(i==2) sum += 2;
        			else if(i==3) sum += 4;
        			else if(i==4) sum += 8;
        			
        		}
        	}
        	
        	System.out.println("#"+tc+" "+sum);
        }
        
	}
	
	private static void turnF(int num, int dir) {
		if(dir == 1) {
			int temp = magnets[num][7];
			for(int i=7; i>=1; i--) {
				magnets[num][i] = magnets[num][i-1];
			}
			magnets[num][0] = temp;
		}
		
		if(dir == -1) {
			int temp = magnets[num][0];
			for(int i=0; i<=6; i++) {
				magnets[num][i] = magnets[num][i+1];
			}
			magnets[num][7] = temp;
		}
		
	}

	private static void turnMagnet(int magNum, int dir) {
		// TODO Auto-generated method stub]
		visited[magNum] = true;
		turnList.add(new TurnNode(magNum, dir));
		
		if(magNum > 1) { // 좌측 비교 
			if(magnets[magNum][6] != magnets[magNum-1][2] && !visited[magNum-1]) {
				turnMagnet(magNum-1, opp(dir));
			}
		}
		if(magNum < 4) {
			if(magnets[magNum][2] != magnets[magNum+1][6] && !visited[magNum+1]) {
				turnMagnet(magNum+1, opp(dir));
			}
		}
		
	}

	private static int opp(int dir) {
		if(dir == -1) return 1;
		else return -1;
	}
}
