package BaekJun;

import java.io.*;
import java.util.*;

public class B2589 {
    public static int L, W;
    public static int[][] map;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[L][W];

        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                if (c == 'L') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    int bfs = bfs(i, j);
                    answer = Math.max(answer, bfs);
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int r, int c) {
        boolean[][] check = new boolean[L][W];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.offer(new int[]{r, c, cnt});
        check[r][c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                cnt = tmp[2];

                if (nr >= 0 && nc >= 0 && nr < L && nc < W && !check[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc, cnt + 1});
                    check[nr][nc] = true;
                }
            }
        }

        // 위로 갈지 아래로 갈지 고르는데, 짧은 거리로 가는걸 구해줘야되기때문에 min 사용
        return cnt;
    }
}
