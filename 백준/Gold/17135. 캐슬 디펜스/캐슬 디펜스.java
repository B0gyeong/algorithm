import java.util.*;

public class Main {
	static int N; static int M;
	static int D;
	static int cntSum;
	static int maxCnt;
	static int [][] matrix;
	static int[][] copyMap;
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r =r; this.c =c;
		}
	}
	static List<Node> t;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt(); M = sc.nextInt();
    	D = sc.nextInt();
    	matrix = new int [N+1][M];
    	t = new ArrayList<>();
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			matrix[r][c] = sc.nextInt();
    		}
    	}
    	
    	maxCnt = Integer.MIN_VALUE;
    	solve(0, 0);
    	System.out.println(maxCnt);
	}
    
	private static void solve(int k, int s) {
		if(k == 3) {
			cntSum = 0;
			copyMap = new int[N][M];
		    for(int i=0; i<N; i++) copyMap[i] = matrix[i].clone();
		    
			boolean repeat = true;
			while(repeat) {
				calculate();
				repeat = go();
			}
			maxCnt = Math.max(cntSum, maxCnt);
		} else {
			for(int i=s; i<M; i++) {
				t.add(new Node(N, i));
				solve(k+1, i+1);
				t.remove(t.size()-1);
			}
		}
		
	}

	private static boolean go() {
		int cnt = 0;
		for(int r=N-1; r>=0; r--) {
    		for(int c=0; c<M; c++) {
    			if(copyMap[r][c]== 1) {
    				if(r == N-1) {
    					copyMap[r][c] = 0;
    				} else {
    					copyMap[r][c] = 0;
    					copyMap[r+1][c] = 1;
        				cnt++;
    				}
    			}
    		}
    	}
		return cnt > 0 ? true : false;
	}

	private static void calculate() {
		List<Node> delete = new ArrayList<>();
		for(int i=0; i<3; i++) {
			int min = Integer.MAX_VALUE;
			int minR = -1; 
			int minC = -1;
			Node curr = t.get(i);
			
			for(int r=N-1; r>0; r--) {
				for(int c=0; c<M; c++) {
					if(copyMap[r][c] == 1) {
						int d = dist(curr.r, curr.c , r, c);
						if(d <= D) {
	                        if(d < min) {
	                            min = d;
	                            minR = r;
	                            minC = c;
	                        } else if(d == min) {
	                            if(c < minC) {
	                                minR = r;
	                                minC = c;
	                            }
	                        }
	                    }
					}
				}
			}
			if(minR != -1) {
	            delete.add(new Node(minR, minC));
	        }
		}
		for(Node target : delete) {
	        if(copyMap[target.r][target.c] == 1) {
	            copyMap[target.r][target.c] = 0;
	            cntSum++;
	        }
	    }
	}

	private static int dist(int r, int c, int r2, int c2) {
		int a = Math.abs(r - r2);
		int b = Math.abs(c - c2);
		return a+b;
	}
}

