package sds;

import java.io.*;
import java.util.*;

public class PlayPoint2 {
    public static int N, M, K;
    public static char[][] map;
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static ArrayList<int[]> list = new ArrayList<>();
    public static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 2
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " "); // 5 6 4

            N = Integer.parseInt(st.nextToken()); // 5
            M = Integer.parseInt(st.nextToken()); // 6
            K = Integer.parseInt(st.nextToken()); // 4
            min = Integer.MAX_VALUE;
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                map[r][c] = 'X';
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '.') {
                        bfs(i, j, 0);
                    } else if (map[i][j] == 'X') {
                        bfs(i, j, 1);
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
            } else {
                sb.append("#").append(tc).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int r, int c, int flag) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;
        int cnt = flag;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] d : dir) {
                int nr = poll[0] + d[0];
                int nc = poll[1] + d[1];
                int min_dis = poll[2];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == '#') {
                    continue;
                }

                if (map[nr][nc] != '#') {
                    if (map[nr][nc] == 'X') {
                        cnt++;
                    }
                    q.offer(new int[]{nr, nc, min_dis + 1});
                    visited[nr][nc] = true;
                }

                if (cnt == K) {
                    min = Math.min(min, min_dis + 1);
                    return;
                }
            }
        }
    }
}