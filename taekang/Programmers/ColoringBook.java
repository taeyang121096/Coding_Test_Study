package Programmers;

public class ColoringBook {

    static int[][] map = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] isUsed;
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        isUsed = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(n, i); // 흠 ..
        }

    }

    public static void dfs(int n, int i) {

        for (int j = 0; j < n; j++) {
            isUsed[i][j] = true;
            if (i + dx[j] >= 0 && j + dy[j] >= 0 && i + dx[j] < 6 && j + dy[j] < 4) { // 인덱스가 0을 벗어나면 안되고, 6,4를 벗어나면 안된다 ?
                if (map[i][j] == map[i + dx[j]][j + dy[j]] && isUsed[i][j] == false) {
                    dfs(n, j);
                }
            }
        }
    }
}

