package BaekJun;

import java.io.*;
import java.util.*;

public class B14502 {
    public static int[][] map;
    public static boolean[][] check;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int max = Integer.MIN_VALUE;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 7
        M = Integer.parseInt(st.nextToken()); // 7
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 벽 세우는것을 dfs로 처리할 수 있음
         */
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int[][] copyMap = new int[N][M];
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2 && !check[i][j]) {
                    q.offer(new int[]{i, j}); // i와j의 좌표를 저장한다
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < dir.length; i++) {
                int nr = tmp[0] + dir[i][0];
                int nc = tmp[1] + dir[i][1];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && copyMap[nr][nc] == 0 && !check[nr][nc]) {
                    copyMap[nr][nc] = 2;
                    check[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);
    }
}
