public class PriorityTree_Pro {


//     0 t 0 0 t
//     0 0 0 0 t
//     0 t 0 0 t
//     0 t t 0 t
//     0 0 0 0 0

    //     3 2     2 ~ 0 1 2 3 4
//     4 - 3 2 5
//     3 - 2 5
//     1 - 2 5
//     2 - 5
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < results.length; i++) {
            check[results[i][0] - 1][results[i][1] - 1] = true;
        }
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                for (int k = 0; k < n; k++) {
                    if (check[r][c] && check[c][k])
                        check[r][k] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++)
                if (check[i][j] || check[j][i])
                    cnt++;
            if (cnt == n - 1)
                answer++;
        }


        return answer;
    }
}

