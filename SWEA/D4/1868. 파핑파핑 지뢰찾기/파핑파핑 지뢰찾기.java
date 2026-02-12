import java.util.*;

public class Solution {
    static int N;
    static int[] dr = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, 1, -1, -1, 1, -1, 1};
    static char[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            matrix = new char[N][N];
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                String line = sc.next();
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = line.charAt(c);
                }
            }

            int click = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] == '.' && !visited[r][c] && isZero(r, c)) {
                        click++;
                        dfs(r, c);
                    }
                }
            }
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] == '.' && !visited[r][c]) {
                        click++;
                    }
                }
            }
            System.out.println("#" + tc + " " + click);
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        if (isZero(r, c)) {
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if (!visited[nr][nc] && matrix[nr][nc] == '.') {
                    if (isZero(nr, nc)) {
                        dfs(nr, nc);
                    } else {
                        visited[nr][nc] = true; 
                    }
                }
            }
        }
    }

    private static boolean isZero(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (matrix[nr][nc] == '*') return false;
        }
        return true;
    }
}