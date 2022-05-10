package BaekJun;

import java.io.*;
import java.util.*;

public class B14889_StartAndLink {
    static int[][] map;
    static int N;
    static int[] start, link
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 축구를 하기위해 모인 사람은 총 N명, N은 짝수
        // N / 2 명으로 이루어진 스타트 팀과 링크 팀으로 나눠야 함

        // 번호 1 ~ N 배정, 능력치 조사, 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때 팀에 더해지는 능력치
        // 팀의 능력치는 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를수 있다. i번 사람과 j번 사람이 같은 팀에 속했을 떄, 팀에 덧해지는 능력치는
        // Sij와 Sji

        // 축구를 재미있게 하기 위해 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.

        /**
         * i 와 j 의 조합을 구하자, N이 4라면, {{1,2}, {3,4}} {{1,3}, {2,4}} {{1,4} {2,3}}
         * 순서 상관 있음,
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 4
        map = new int[N][N];
        start = new int[N / 2];
        link = new int[N / 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 0 1 2 3
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(N, N / 2, 0, 0);

        System.out.println(min);

    }

    static void dfs(Integer N, Integer M, Integer select, Integer idx) {
        // 종료 조건
        check = new boolean[N];

        // 종료 조건에서 이미 start는 {1,2,..} 일거다 ..
        if (M == select) {
            for (int i = 0; i < M; i++) { //
                check[start[i]] = true;
            }

            /**
             * 여기서 비교 메소드가 들어간다.
             * check = { t, t, f, f }
             */
            diff();

            return;
        }

        if (idx >= N) {
            return;
        }

        // 실행 조건

        // 선택 되었을 경우
        start[select] = idx;
        dfs(N, M, select + 1, idx + 1);

        // 선택 되지 않았을 경우
        dfs(N, M, select, idx + 1);

    }

    private static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!check[i] && !check[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}
