package BaekJun;

import java.io.*;
import java.util.*;

public class B2667_danji_v2 {
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 7
        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                int k = input.charAt(j) - '0';
                map[i][j] = k;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && map[i][j] == 1) {
                    int b = bfs(i, j);
                    cnt++;
                    list.add(b);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for (Integer idx : list) {
            if (idx > 0)
                System.out.println(idx);
        }
    }

    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        check[r][c] = true; // 들어온 당시에도 들어온거기 때문에 true 체크해줘야함.!!
        int ans = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            // 종료 조건

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && map[nr][nc] != 0) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}