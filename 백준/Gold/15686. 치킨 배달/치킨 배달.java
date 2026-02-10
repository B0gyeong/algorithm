import java.util.*;

public class Main {
	static int N; static int M;
	static int minDist;
	static int [][] matrix;
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r; this.c = c;
		}
	}
	static List <Node> house;
	static List <Node> chicken;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	matrix = new int [N][N]; 
    	house = new ArrayList<>();
    	chicken = new ArrayList<>();
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<N; c++) {
    			matrix[r][c] = sc.nextInt();
    			if(matrix[r][c]==1) house.add(new Node(r, c));
    		}
    	}
    	
    	minDist = Integer.MAX_VALUE;
    	
    	solve(0,0);
    	System.out.println(minDist);

	}
    
	private static void solve(int k, int s) {
		if(k==M) {
			checkDist();
		} else {
			for(int i=s; i<N*N; i++) {
	    		int r = i/N;
	    		int c = i%N;
	    		if(matrix[r][c] == 2) {
	    			chicken.add(new Node(r, c));
	    			solve(k+1, i+1);
	    			chicken.remove(chicken.size()-1);
	    		}
	    	}
		}
	}

	private static void checkDist() {
		int minSum = 0;
		for(int i=0; i<house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) {
				min = Math.min(min, calaulate(house.get(i), chicken.get(j)));
			}
			minSum+=min;
		}
		minDist = Math.min(minDist, minSum);
	}

	private static int calaulate(Node node, Node node2) {
		int a = Math.abs(node.r - node2.r);
		int b = Math.abs(node.c - node2.c);
		return a+b;
	}
}

