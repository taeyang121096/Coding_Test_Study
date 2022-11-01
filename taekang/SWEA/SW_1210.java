package SWEA;

import java.io.*;
import java.util.*;

public class SW_1210 {
    public static int[][] map;
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 0; T < 10; T++) {
            map = new int[100][100];
            int N = Integer.parseInt(br.readLine()); // 1, 2, 3,....
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                if (map[0][i] == 1) {
                    if(bfs(0, i))
                        System.out.println("#" + N + " " + i);
                }
            }
        }
    }

    private static boolean bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[100][100];
        q.offer(new int[]{r, c});
        check[r][c] = true;
        // 종료 조건이 존재해야하는데, 그 종료조건은
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && !check[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                    break;
                } else if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && !check[nr][nc] && map[nr][nc] == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
