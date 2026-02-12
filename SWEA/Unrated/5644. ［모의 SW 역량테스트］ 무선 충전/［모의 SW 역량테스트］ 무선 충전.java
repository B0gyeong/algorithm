import java.util.*;

public class Solution {
	static int A;
	static int [] maxP;
	static int [] dr = {0, 0, 1, 0, -1};
	static int [] dc = {0, -1, 0, 1, 0};
	static Node [] BPs;
	static List<Node> aBC; 
	static List<Node> bBC;
	static class Node{
		int row, col, C, P;
		Node(int row, int col, int C, int P){
			this.row = row; this.col = col; this.C = C; this.P = P;
		}
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	int M = sc.nextInt();
        	A = sc.nextInt();
        	int [] moveA = new int [M];
        	int [] moveB = new int [M];
        	int [] maxP = new int [M+1];
        	for(int i=0; i<M; i++) moveA[i] = sc.nextInt(); 
        	for(int i=0; i<M; i++) moveB[i] = sc.nextInt(); 
        	BPs = new Node [A];
        	for(int i=0; i<A; i++) {
        		int row = sc.nextInt(); int col = sc.nextInt();
        		int C = sc.nextInt();
        		int P = sc.nextInt();
        		BPs[i] = new Node(row, col, C, P);
        	}
        	
        	int rA = 1; int cA = 1;
        	int rB = 10; int cB = 10;
        	
        	for(int t=0; t<=M; t++) {
        		aBC = new ArrayList<>();
        		bBC = new ArrayList<>();
        		checkInBC(rA, cA, aBC);
        		checkInBC(rB, cB, bBC);
        		
        		maxP[t] = calculate();
        		
        		if(t==M) continue;
        		rA = rA + dr[moveA[t]];
        		cA = cA + dc[moveA[t]];
        		rB = rB + dr[moveB[t]];
        		cB = cB + dc[moveB[t]];
        	}
        	
        	int ans = 0;
        	for(int i=0; i<=M; i++) {
        		ans+=maxP[i];
        	}
        	System.out.println("#"+tc+" "+ans);
        }
	}
    
	private static void checkInBC(int r, int c, List<Node> BCList) {
		// 현재 위치가 어디 BC에 포함되어있는지 체크
		for(int i=0; i<A; i++) {
			Node curr = BPs[i];
			int dist1 = Math.abs(r-curr.row);
			int dist2 = Math.abs(c-curr.col);
			if(dist1+dist2 <= curr.C) {
				BCList.add(curr);
			}
		}
		
	}
	
	private static int calculate() {
		// aBC, bBC에 있는 값들로 최대 충전 양 확인 (비어있는 것도 확인)
		if(aBC.size() == 0 ) {
			int maxNum = 0;
			for(int b=0; b<bBC.size(); b++) {
				Node currB = bBC.get(b);
				if(currB.P > maxNum) maxNum = currB.P;
			}
			return maxNum;
		}
		
		if(bBC.size() == 0 ) {
			int maxNum = 0;
			for(int a=0; a<aBC.size(); a++) {
				Node currA = aBC.get(a);
				if(currA.P > maxNum) maxNum = currA.P;
			}
			return maxNum;
		}
		
		int maxNum = 0;
		for(int a=0; a<aBC.size(); a++) {
			for(int b=0; b<bBC.size(); b++) {
				int sum = 0;
				Node currA = aBC.get(a);
				Node currB = bBC.get(b);
				if(currA.row == currB.row && currA.col == currB.col) {
					sum = currA.P;
				} else {
					sum = currA.P + currB.P;
				}
				maxNum = Math.max(maxNum, sum);
			}
		}
		return maxNum;
	}
}

