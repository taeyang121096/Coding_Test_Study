public class Break_Pro {

    //     skill(공격, 회복)
//     파괴되지 않은 건물 수 리턴
//     1 ~ 1000 r, c
//     1 ~ 1000 내구도
//     skill 1 ~ 250000
//     type 1 공격, 2 회복 degree
//
    static int[][] mat;
    static int[][] sum;
    static int answer;

    static void count() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (j != 0)
                    sum[i][j] += sum[i][j - 1];
                mat[i][j] += sum[i][j];

                if (mat[i][j] > 0)
                    answer++;
            }
        }
    }

//    -4 -4 -4 -4 -4 4
//    -4 -4 -4 0 0 4
//    -6 -6 -6 -6 -4 4
//    -4 0 0 0 0 4
//

    public int solution(int[][] board, int[][] skill) {
        answer = 0;
        mat = board;
        int r = board.length;
        int c = board[0].length;
        sum = new int[r + 1][c + 1];
//         -4 +2-10    22 -14 = 8
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            degree *= type == 1 ? -1 : 1;
            for (int i = r1; i <= r2; i++) {
                sum[i][c1] += degree;
                sum[i][c2 + 1] += -degree;
            }
        }

        count();
        return answer;

    }
}

