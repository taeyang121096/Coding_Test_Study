package SWEA.D3.day4;

import java.io.*;
import java.util.*;

public class SW_5215 {
    public static int N, L, Ti, Ki;
    public static int[][] arr;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         * 5개의 재료, 제한 칼로리는 1000
         * 왼쪽은 본인이 정한 점수, 그것의 칼로리
         * 1000 이하를 만족하는 음식의 조합중 가장 높은 햄버거의 점수
         */
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());    // 재료 수
            L = Integer.parseInt(st.nextToken());    // 제한 칼로리

            arr = new int[N][2];
            max = Integer.MIN_VALUE;
            // 재료 정보
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken()); // 점수
                arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(int idx, int scr, int cal) {
        if (cal > L) return;
        if (cal <= L) max = Math.max(max, scr);
        if (idx == N) return;

        dfs(idx + 1, scr + arr[idx][0], cal + arr[idx][1]);
        dfs(idx + 1, scr, cal);
    }
}
