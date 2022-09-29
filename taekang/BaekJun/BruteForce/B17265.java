package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B17265 {
    public static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static int[][] dir = {{1, 0}, {0, 1}};
    public static char[][] map;
    public static boolean[][] visited;
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, map[0][0] - '0', false);

        System.out.println(max + " " + min);
    }

    public static void dfs(int r, int c, int sum, boolean isOpe) {
        if (r == N - 1 && c == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        // 오른쪽으로 갈 때
        if (c + 1 < N) {
            if (isOpe) {
                if (map[r][c] == '*') {
                    dfs(r, c + 1, sum * (map[r][c + 1] - '0'), false);
                } else if (map[r][c] == '+') {
                    dfs(r, c + 1, sum + (map[r][c + 1] - '0'), false);
                } else {
                    dfs(r, c + 1, sum - (map[r][c + 1] - '0'), false);
                }
            } else { // 숫자 일때 boolean을 바꾸어준다 (다음 나올것이 연산자 일것이라는 뜻)
                dfs(r, c + 1, sum, true);
            }
        }
        // 아래로 갈 때
        if (r + 1 < N) {
            if (isOpe) {
                if (map[r][c] == '*') {
                    dfs(r + 1, c, sum * (map[r + 1][c] - '0'), false);
                } else if (map[r][c] == '+') {
                    dfs(r + 1, c, sum + (map[r + 1][c] - '0'), false);
                } else {
                    dfs(r + 1, c, sum - (map[r + 1][c] - '0'), false);
                }
            } else { // 숫자 일때 boolean을 바꾸어준다 (다음 나올것이 연산자 일것이라는 뜻)
                dfs(r + 1, c, sum, true);
            }
        }
    }
}
