import java.util.*;

public class Solution {
    static int N;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
    static class Node {
    	int num, d, max;
    	Node(int num, int d, int max){
    		this.num = num; this.d = d; this.max = max;
    	}
    }
    static Node [][] matrix;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int K = sc.nextInt();
        	matrix = new Node [N][N];
        	for(int i=0; i<K; i++) {
        		int r = sc.nextInt();
        		int c = sc.nextInt();
        		int num = sc.nextInt();
        		int d = sc.nextInt();
        		matrix[r][c] = new Node(num, d, num);
        	}
        	
        	
        	for(int repeat = 0; repeat<M; repeat++) {
        		Node [][] nextMap = new Node [N][N];
        		
        		for(int r=0; r<N; r++) {
            		for(int c=0; c<N; c++) {
            			if (matrix[r][c] != null) {
            				Node curr = matrix[r][c];
            				int nr = r+dr[curr.d-1];
            				int nc = c+dc[curr.d-1];
            				if(nr==0||nr==N-1||nc==0||nc==N-1) {
            					if(curr.num/2 != 0) {
            						nextMap[nr][nc] = new Node(curr.num/2, ((curr.d-1) ^ 1)+1, curr.num/2);
            					}
            				} else {
            					if(nextMap[nr][nc] == null) {
            						nextMap[nr][nc] = new Node(curr.num, curr.d, curr.num);
            					} else {
            						Node post = nextMap[nr][nc];
            						if(post.max > curr.num) {
            							nextMap[nr][nc] = new Node(curr.num+post.num, post.d, post.max);
            						} else {
            							nextMap[nr][nc] = new Node(curr.num+post.num, curr.d, curr.max);
            						}
            					}
            				}
            			}
            		}
            	}
        		matrix = nextMap;
        	}
        	
        	int cnt = 0;
        	for(int r=0; r<N; r++) {
        		for(int c=0; c<N; c++) {
        			if (matrix[r][c] != null) {
        				cnt += matrix[r][c].num;
        			}
        		}
        	}
        	System.out.println("#"+tc+" "+cnt);
        }
        
	}

}
