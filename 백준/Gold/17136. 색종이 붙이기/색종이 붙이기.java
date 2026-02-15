import java.util.*;

public class Main {
	static int minAns;
	static int [] coloredPapers;
	static int [][] paper;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	paper = new int [10][10];
    	for(int r=0; r<10; r++) {
    		for(int c=0; c<10; c++) {
    			paper[r][c] = sc.nextInt();
    		}
    	}
    	coloredPapers = new int [6];
    	Arrays.fill(coloredPapers, 5);
    	
    	minAns = Integer.MAX_VALUE;
    	
    	solve(0, 0);
    	System.out.println(minAns== Integer.MAX_VALUE ? -1 : minAns);
	}

	private static void solve(int num, int cnt) {
		if(num == 100) {
			boolean sucess = true;
			for(int r=0; r<10; r++) {
	    		for(int c=0; c<10; c++) {
	    			if(paper[r][c] == 1) sucess = false;
	    		}
	    	}
			if(sucess) minAns = Math.min(minAns, cnt);
			return;
		}
		
		int r = num/10;
		int c = num%10;
		if(paper[r][c]==1) {
			for(int i=5; i>0; i--) {
				if(check(r,c,i) && coloredPapers[i]>0) {
					attach(r,c,i);
					coloredPapers[i]--;
					solve(num+i, cnt+1);
					diattach(r,c,i);
					coloredPapers[i]++;
				} else continue;
			}
		} else {
			solve(num+1, cnt);
		}
		
	}

	private static void diattach(int r, int c, int i) {
		for(int a=r; a<r+i; a++) {
			for(int b=c; b<c+i; b++) {
				paper[a][b] = 1;
			}
		}
		
	}

	private static void attach(int r, int c, int i) {
		for(int a=r; a<r+i; a++) {
			for(int b=c; b<c+i; b++) {
				paper[a][b] = 2;
			}
		}
	}

	private static boolean check(int r, int c, int i) {
		// 붙일 수 있는지 확인하는 함수
		for(int a=r; a<r+i; a++) {
			for(int b=c; b<c+i; b++) {
				if(isWall(a,b)) return false;
				if(paper[a][b] != 1) return false;
			}
		}
		return true;
	}

	private static boolean isWall(int a, int b) {
		return a<0 || a>=10 || b<0 || b>=10;
	}
}