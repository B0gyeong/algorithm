import java.util.*;

public class Main {	
	static int k;
	static int [] selected, maxArr, minArr;
	static char [] chars;
	static boolean [] visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt();
        chars = new char [k];
        maxArr = new int [k+1];
        minArr = new int [k+1];
        Arrays.fill(minArr, 9);
        selected = new int [k+1];
        visited = new boolean [10];
        
        for(int i=0; i<k; i++) {
        	chars[i] = sc.next().charAt(0);
        }
        
        perm(0);
        
        for(int i=0; i<k+1; i++) {
			System.out.print(maxArr[i]);
		}
        System.out.println();
        
        for(int i=0; i<k+1; i++) {
			System.out.print(minArr[i]);
		}
        System.out.println();
        
	}
    
	private static void perm(int idx) {

		if(idx == k+1) {
			// 크기 비교 
			if(bigger(selected, maxArr)) {
				copyList('b' , selected);
			}
			if(bigger(minArr, selected)) {
				copyList('s', selected);
			}
			return;
		}
		
		for(int i=0; i<=9; i++) {
			if(visited[i]) continue;
			
			// 부등호 관련하여 가지치기 
			if(idx != 0) {
				if(!checkVaild(selected[idx-1], chars[idx-1], i)) continue;
			}
			
			visited[i] = true;
			selected[idx] = i;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	private static void copyList(char a , int[] arr2) {
		if(a == 'b') {
			for(int i=0; i<k+1; i++) {
				maxArr[i] = arr2[i];
			}
		}
		if(a == 's') {
			for(int i=0; i<k+1; i++) {
				minArr[i] = arr2[i];
			}
		}
		
	}

	private static boolean bigger(int[] arr1, int[] arr2) {
		for(int i=0; i<k+1; i++) {
			if(arr1[i] > arr2[i]) return true;
			if (arr1[i] < arr2[i]) return false;
		}
		return false;
	}

	private static boolean checkVaild(int i, char c, int j) {
		if(c == '>') {
			return i > j;
		} else {
			return i < j;
		}
	}
}