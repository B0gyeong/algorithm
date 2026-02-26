import java.util.*;

public class Solution {
    static int N, M, K;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
    static int [][] matrix;
    static class Cell {
        int r, c, hp, time, state;
        Cell(int r, int c, int hp) {
            this.r = r;
            this.c = c;
            this.hp = hp;
            this.time = hp;
            this.state = 1;
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            matrix = new int [N+2*K][M+2*K];

            Queue <Cell> cell = new LinkedList<>();

            for(int r=0; r<N; r++) {
                for(int c=0; c<M; c++) {
                    matrix[K+r][K+c]=sc.nextInt();
                    if(matrix[K+r][K+c] > 0) cell.add(new Cell(K+r, K+c, matrix[K+r][K+c]));
                }
            }


            for(int i=0; i<K; i++) {
                Queue <Cell> Candidates = new LinkedList<>();

                int L = cell.size();
                for(int j=0; j<L; j++) {
                    Cell curr = cell.poll();


                    if(curr.state == 1) {
                        curr.time--;
                        if(curr.time == 0) {
                            curr.time = curr.hp;
                            curr.state = 2;
                            cell.add(curr);
                        } else {
                            cell.add(curr);
                        }
                    } else if (curr.state == 2) {
                        if(curr.time == curr.hp) {
                            for(int d=0; d<4; d++) {
                                if(matrix[curr.r+dr[d]][curr.c+dc[d]] == 0) {
                                    Candidates.add(new Cell (curr.r+dr[d], curr.c+dc[d], curr.hp));
                                }
                            }
                        } 

                        curr.time--;
                        if(curr.time > 0) {
                            cell.add(curr);
                        }
                    }
                }

                
                List<Cell> babyList = new ArrayList<>(Candidates);
                Collections.sort(babyList, (o1, o2) -> o2.hp - o1.hp);
                for(Cell baby : babyList) {
                    if(matrix[baby.r][baby.c] == 0) { 
                        matrix[baby.r][baby.c] = baby.hp;
                        cell.add(baby); 
                    }
                }
            }
            
            System.out.println("#"+tc+" "+cell.size());
        }


    }
}