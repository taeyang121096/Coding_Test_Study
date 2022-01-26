public class Place_Kakao {

    static char[][] mat = new char[5][5];
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] check;
    static int flag;

    static void make(int row, char[] tmp) {
        int index = 0;
        for (char c : tmp) {
            mat[row][index++] = c;
        }
    }

    static void dfs(int r, int c, int len) {
        check[r][c] = true;
        if (flag == 0)
            return;

        if (len >= 1 && mat[r][c] == 'P') {

            flag = 0;
            return;
        }
        if (len >= 1 && mat[r][c] == 'X') {
            return;
        }
        if (len == 2)
            return;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && check[nr][nc] != true) {
                dfs(nr, nc, len + 1);
            }

        }

    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            flag = -1;
            for (int j = 0; j < 5; j++) {
                make(j, places[i][j].toCharArray());
            }

            for (int r = 0; r < 5; r++) {
                if (flag == 0)
                    break;
                for (int c = 0; c < 5; c++) {
                    if (flag == 0)
                        break;
                    if (mat[r][c] == 'P') {
                        check = new boolean[5][5];

                        dfs(r, c, 0);

                    }
                }
            }
            if (flag == -1)
                flag = 1;
            answer[i] = flag;
        }
        return answer;
    }
}

