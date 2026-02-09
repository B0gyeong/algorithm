import java.util.*;

public class Solution {
	static String [] value;
	static int [][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			tree = new int [N+1][2];
			value = new String [N+1];
			for(int i=0; i<N; i++) {
				String str = sc.nextLine();
				String [] strArr = str.split(" ");
				
				int id = Integer.parseInt(strArr[0]); 
			    value[id] = strArr[1];  

			    if (strArr.length >= 3) {
			        tree[id][0] = Integer.parseInt(strArr[2]); 
			    }
			    if (strArr.length >= 4) {
			        tree[id][1] = Integer.parseInt(strArr[3]);
			    }
			}
			System.out.print("#"+tc+" ");
			inorder(1);
			System.out.println();
			
		}
	}

	private static void inorder(int v) {
		if(v != 0) {
			inorder(tree[v][0]);
			System.out.print(value[v]);
			inorder(tree[v][1]);
		}
		
	}
}