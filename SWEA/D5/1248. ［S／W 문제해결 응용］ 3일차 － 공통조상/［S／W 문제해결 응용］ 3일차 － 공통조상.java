import java.util.*;

public class Solution {
	static int cnt;
	static int [][] tree;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1; tc<=T; tc++) {
    		int V = sc.nextInt();
    		int E = sc.nextInt();
    		int node1 = sc.nextInt(); int node2 = sc.nextInt();
    		tree = new int [V+1][3];
    		for(int i=0; i<E; i++) {
    			int from = sc.nextInt();
    			int to = sc.nextInt();
    			if(tree[from][0]==0)  tree[from][0] = to;
    			else tree[from][1] = to;
    			tree[to][2] = from;
    		}
    		
    		ArrayList<Integer> node1Parents = new ArrayList<>();
    		ArrayList<Integer> node2Parents = new ArrayList<>();
    		int node1P = tree[node1][2]; int node2P = tree[node2][2];
    		node1Parents.add(node1P); 
    		node2Parents.add(node2P);
    		while(node1P != 1) {
    			node1P = tree[node1P][2];
    			node1Parents.add(node1P);
    		}
    		while(node2P != 1) {
    			node2P = tree[node2P][2];
    			node2Parents.add(node2P);
    		}
    		Collections.reverse(node1Parents);
    		Collections.reverse(node2Parents);
    		int sameParent = 1;
    		for(int i=0; i<Math.min(node1Parents.size(), node2Parents.size()); i++) {
    			if(node1Parents.get(i).equals(node2Parents.get(i))) {
    				sameParent = node1Parents.get(i);
    			} else break;
    		}
    		
    		cnt = 0;
    		traverse(sameParent);
    		
    		System.out.println("#" + tc + " " + sameParent+ " " + cnt);
    	}
    }

	private static void traverse(int v) {
		if(v != 0) {
			cnt++;
			traverse(tree[v][0]);
			traverse(tree[v][1]);
		}
	}
}
