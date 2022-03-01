package BaekJun;

import java.io.*;
import java.util.*;

// DFS
public class B2178_maze {
    static int[][] map;
    static boolean[][] check;
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s1 = input.split(" ");
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);

        check = new boolean[N + 1][M + 1];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input2 = br.readLine();
            String[] s2 = input2.split("");
            for (int j = 0; j < s2.length; j++) {
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }

//        dfs(0, 0, 1);
//        System.out.println(answer);
        bfs(0, 0, 1);
        System.out.println(min);
    }

    static void dfs(int r, int c, int cost) {
        // 종료 조건
        if (r == N - 1 && c == M - 1) {
            answer = Math.min(answer, cost);
            return;
        }
        // 실행
        for (int d[] : dir) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] == false && map[nr][nc] != 0) {
                check[nr][nc] = true;
                dfs(nr, nc, cost + 1);
                check[nr][nc] = false;
            }
        }
    }

    static void bfs(int r, int c, int cost) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] > o2[2] ? 1 : -1;
            }
        });
        q.offer(new int[]{r, c, cost});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                min = Math.min(min, tmp[2]);
                break;
            }
            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] == false && map[nr][nc] != 0) {
                    check[nr][nc] = true;
                    q.offer(new int[]{nr, nc, tmp[2] + 1});
                }
            }
        }
    }
}
