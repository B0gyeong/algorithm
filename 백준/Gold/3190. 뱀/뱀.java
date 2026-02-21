import java.util.*;

public class Main {
	static int N, K, L;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static class Turn {
		int t;
		char d;
		Turn(int t, char d) {
			this.t = t; this.d = d;
		}
	}
	static class Tails {
		int r, c;
		Tails(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boolean [][] snake = new boolean [N+1][N+1];
		
		K = sc.nextInt();
		boolean [][] apples = new boolean [N+1][N+1];
		for(int i=0; i<K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			apples[r][c] = true;
		}
		
		L = sc.nextInt();
		Queue <Turn> turns = new LinkedList<>();
		for(int i=0; i<L; i++) {
			int X = sc.nextInt();
			char C = sc.next().charAt(0);
			turns.add(new Turn(X, C));
		}
		
		int nr = 1; int nc = 1;
		Queue <Tails> tails = new LinkedList<>();
		tails.add(new Tails(nr, nc));
		int d = 3;
		snake[1][1] = true;
		int time = 0;
		while(true) {
			time++;
			nr = nr+dr[d];
			nc = nc+dc[d];
			
			if(nr<=0 || nr>N || nc<=0 || nc>N || snake[nr][nc]) break;
			snake[nr][nc] = true;
			tails.add(new Tails(nr, nc));
			
			if(!apples[nr][nc]) {
				Tails tail = tails.poll();
				snake[tail.r][tail.c] = false;
			} else {
				apples[nr][nc] = false;
			}
			
			if(!turns.isEmpty() && turns.peek().t == time) {
				Turn curr = turns.poll();
				d = move(curr.d , d);
			}
		}
		System.out.println(time);
	}
	
	private static int move(char d, int currd) {
		int reD = 0;
		if(d == 'L') {
			if(currd == 0) reD = 2;
			if(currd == 1) reD = 3;
			if(currd == 2) reD = 1;
			if(currd == 3) reD = 0;
		} else {
			if(currd == 0) reD = 3;
			if(currd == 1) reD = 2;
			if(currd == 2) reD = 0;
			if(currd == 3) reD = 1;
		}
		
		return reD;
	}

}
