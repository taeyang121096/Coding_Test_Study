package BaekJun;

import java.io.*;
import java.util.*;

public class B2178_maze_v2 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] check;
    static int min = Integer.MAX_VALUE;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void bfs(int r, int c, int cost) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, cost});
        check[r][c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                min = Math.min(min, tmp[2]);
                break;
            }
            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !check[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc, tmp[2] + 1});
                    check[nr][nc] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input2 = br.readLine();
            String[] s2 = input2.split("");
            for (int j = 0; j < s2.length; j++) {
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }

        bfs(0,0, 1);
        System.out.println(min);
    }
}
