package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

/**
 * R개의 행과 C개의 열로 이루어진 테이블, 테이블의 원소는 알파벳 소문자
 */
public class B23352 {
    public static int N, M;
    public static int[][] map;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max_k0 = Integer.MIN_VALUE;
        int max_k1 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    int[] k = bfs(i, j);
                    if (max_k0 < k[0]) { //
                        max_k0 = k[0]; // 가장 큰애가 들어오는데
                        max_k1 = k[1];
                    } else if (max_k0 == k[0]) {
                        max_k1 = Math.max(max_k1, k[1]);
                    }
                }
            }
        }

        System.out.println(max_k1);
    }

    public static int[] bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{r, c, 1});
        visited[r][c] = true;
        int cnt = 0;
        int max = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                int len = tmp[2];
                cnt = len;
                max = map[tmp[0]][tmp[1]];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] != 0) {
                    q.offer(new int[]{nr, nc, len + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return new int[]{cnt, map[r][c] + max};
    }
}
