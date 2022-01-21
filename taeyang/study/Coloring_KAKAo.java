import java.util.*;

public class Coloring_KAKAo {


    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int area = 0;
    static int count = 1;
    static int max = 0;
    static int[][] Picture;
    static int M;
    static int N;

    static void dfs(int row, int col, int val) {

        Picture[row][col] = 0;

        for (int[] d : dir) {
            int nr = row + d[0];
            int nc = col + d[1];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && Picture[nr][nc] == val) {
                count++;
                dfs(nr, nc, val);
            }
        }

    }

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        Picture = picture;
        M = m;
        N = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    dfs(i, j, picture[i][j]);
                    area++;
                    max = Math.max(count, max);
                    count = 1;
                }
            }
        }

        answer[0] = area;
        answer[1] = max;
        return answer;
    }
}

