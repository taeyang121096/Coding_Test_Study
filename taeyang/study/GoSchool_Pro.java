public class GoSchool_Pro {

//     1,1 -> 집 m,n -> 학교
//     r = m c = n
//     m, n 1 ~ 100 자연수
//     물에 잠긴 0 ~ 10개 이하
//     움직이는 방향 : 오른쪽, 아래쪽
//     최단경로의 개수 카운트
//     1,000,000,007 나눈 나머지 return
//     1,1 ->
//     위 왼
//     1 1  1 1
//     1 -1 1 2
//     1 1  2 4
//
//     1  1  1
//     1  -1 1
//     -1 0  1

    public int solution(int m, int n, int[][] puddles) {

        int size = 1000000007;
        int[][] mat = new int[m][n];
        mat[0][0] = 1;
        for (int[] p : puddles) {
            mat[p[0] - 1][p[1] - 1] = -1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1)
                    continue;
                if (i == 0 && j == 0)
                    continue;
                if (i == 0) {
                    if (mat[i][j - 1] != -1)
                        mat[i][j] = (mat[i][j] + mat[i][j - 1]) % size;
                } else if (j == 0) {
                    if (mat[i - 1][j] != -1)
                        mat[i][j] = (mat[i][j] + mat[i - 1][j]) % size;
                } else {
                    if (mat[i][j - 1] != -1 && mat[i - 1][j] != -1)
                        mat[i][j] = (mat[i][j] + mat[i][j - 1] + mat[i - 1][j]) % size;
                    else if (mat[i][j - 1] != -1)
                        mat[i][j] = (mat[i][j] + mat[i][j - 1]) % size;
                    else
                        mat[i][j] = (mat[i][j] + mat[i - 1][j]) % size;
                }
            }
        }

        return mat[m - 1][n - 1];
    }
}

