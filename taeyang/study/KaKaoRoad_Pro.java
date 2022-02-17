public class KaKaoRoad_Pro {

    //     up : 1, lf : 2
    static int[][] dir = {{1, 0, 1}, {0, 1, 2}, {-1, 0, 1}, {0, -1, 2}};
    static int answer = Integer.MAX_VALUE;
    static int n;
    static boolean[][] check;
    static int[][] B;

    static void dfs(int r, int c, int cate, int cost) {
        if (answer < cost)
            return;
        if (r == n - 1 && c == n - 1) {
            answer = Math.min(answer, cost);
            return;
        }


        for (int d[] : dir) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            int ca = d[2];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && check[nr][nc] == false && B[nr][nc] != 1) {
                if (cate == ca) {
                    if (cost + 100 < answer) {
                        check[nr][nc] = true;
                        dfs(nr, nc, ca, cost + 100);
                        check[nr][nc] = false;
                    }
                } else {
                    if (cost + 600 < answer) {
                        check[nr][nc] = true;
                        dfs(nr, nc, ca, cost + 600);
                        check[nr][nc] = false;
                    }
                }
            }
        }
    }

    public int solution(int[][] board) {
        n = board.length;
        check = new boolean[n][n];
        check[0][0] = true;
        B = board;
        dfs(0, 0, 1, 0);
        dfs(0, 0, 2, 0);

        return answer;
    }
}

