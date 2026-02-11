import java.util.*;

public class Main {
    static int N;
    static int outCnt;
    static int score;
    static int maxScore;
    static int [] scoreArr;
    static int [] tempPlayers;
    static boolean [] visited;
    static int [][] matrix;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int [N][9];
        for(int r=0; r<N; r++) {
        	for(int c=0; c<9; c++) {
        		matrix[r][c] = sc.nextInt(); 
        	}
        }
        
        tempPlayers = new int [8];
        visited = new boolean [9];
        maxScore = Integer.MIN_VALUE;
        perm(0);
        System.out.println(maxScore);
	}

	private static void perm(int k) {
		// 자리가 고정되어 있는 1번 선수를 제외한 2번~9번 선수를 줄세우자
		if(k == 8) {
			maxScore = Math.max(maxScore, playGame());
		}
		
		for(int i=1; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tempPlayers[k] = i;
				perm(k+1);
				visited[i] = false;
			}
		}
	}

	private static int playGame() {
		// 건네받은 선수에 1번 선수를 4번 타자로 포함시킨 뒤
		int [] playerArr = new int [9];
		for(int i=0; i<9; i++) {
			if(i<3) {
				playerArr[i] = tempPlayers[i];
			} else if(i == 3) {
				playerArr[i] = 0;
			} else {
				playerArr[i] = tempPlayers[i-1];
			}
		}
		
		// N번의 이닝을 진행하자
		score = 0;
		int playerIdx = 0;
		for(int game = 0; game<N; game++) {
			outCnt = 0;
			scoreArr = new int [3];
			while(true) {
				score(matrix[game][playerArr[playerIdx]]);
				playerIdx = (playerIdx+1) % 9;
				if(outCnt >= 3) break;
			}
		}
		return score;
	}

	private static void score(int i) {
		// 현재 상황에서 i번의 결과가 일어난다면 어떻게 되는지
		switch (i) {
		case 1: 
			for(int j=2; j>=0; j--) {
				if(scoreArr[j] == 1) {
					scoreArr[j] = 0;
					if(j==2) {
						score++;
						continue;
					}
					scoreArr[j+1] = 1;				
				}
			}
			scoreArr[0]=1;
			break;
		case 2:
			for(int j=2; j>=0; j--) {
				if(scoreArr[j] == 1) {
					scoreArr[j] = 0;
					if(j != 0) {
						score++;
						continue;
					}
					scoreArr[j+2] = 1;	
				}
			}
			scoreArr[1]=1;
			break;
		case 3:
			int sum = scoreArr[0] + scoreArr[1] + scoreArr[2];
			score+=sum;
			Arrays.fill(scoreArr, 0);
			scoreArr[2]=1;
			break;
		case 4:
			int sumh = scoreArr[0] + scoreArr[1] + scoreArr[2];
			score+=sumh;
			Arrays.fill(scoreArr, 0);
			score++;
			break;
		case 0: 
			outCnt++;
			break;
		}
		
	}

}
