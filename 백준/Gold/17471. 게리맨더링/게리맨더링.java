import java.util.*;

public class Main {
    static int N;
    static int minVal;
    static int checkNon;
    static int [] memberNum;
    static int [][] adjMatrix;
    static List<Integer> teamA;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memberNum = new int [N+1];
        for(int i=1; i<=N; i++) memberNum[i] = sc.nextInt();
        adjMatrix = new int [N+1][];
        for(int i=1; i<=N; i++) {
            int L = sc.nextInt();
            int [] adjArr = new int [L];
            for(int j=0; j<L; j++) adjArr[j] = sc.nextInt();
            adjMatrix[i] = adjArr;
        }

        teamA = new ArrayList<>();
        minVal = Integer.MAX_VALUE;
        checkNon = 0;
        DFS(1, teamA);
        System.out.println(checkNon==0 ? -1 : minVal);
    }

	private static void DFS(int idx, List<Integer> teamA) {
	    if(idx == N+1) {
	    	List<Integer> teamB = new LinkedList<>();
			for(int i=1; i<=N; i++) {
				if(!teamA.contains(i)) teamB.add(i);
			}
			
			if (checkValid(teamA) && checkValid(teamB)) {
				checkNon++;
		        minVal = Math.min(minVal, calculateDiff(teamA, teamB));
		    }
		    return;
	    }
	    
	    teamA.add(idx);
	    DFS(idx+1, teamA);
	    teamA.remove(teamA.size()-1);
	    DFS(idx+1, teamA);
	}

	private static int calculateDiff(List<Integer> teamA, List<Integer> teamB) {
		int sumA = 0;
		int sumB = 0;
		for(int a : teamA) {
			sumA += memberNum[a];
		}
		for(int b : teamB) {
			sumB += memberNum[b];
		}
		return Math.abs(sumA-sumB);
	}

	private static boolean checkValid(List<Integer> team) {
		if(team.size() == 0) return false;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		int n = team.get(0);
		visited[n] = true;
		q.add(n);
		
		int count = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int v : adjMatrix[curr]) {
				if(!visited[v] && team.contains(v)) {
					q.add(v);
					visited[v] = true;
					count++;
				}
			}
		}
		
		return count == team.size();
	}

	
}
