package BaekJun;

import java.io.*;
import java.util.*;

public class B1012_UkiNong {

    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] map;
    static boolean[][] check;

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // i = 가로,행 // j = 세로, 열

            for (int[] d : dir) {
                int nr = tmp[0] + d[0]; // 가로, 행 row,
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 1 & !check[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 2

        for (int i = 0; i < T; i++) {
            int earthWorm = 0;

            String input = br.readLine();
            String[] str = input.split(" ");
            M = Integer.parseInt(str[0]); // 10
            N = Integer.parseInt(str[1]); // 8
            K = Integer.parseInt(str[2]); // 17

            map = new int[M][N];
            check = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                String input2 = br.readLine();
                String[] str2 = input2.split(" ");
                int r = Integer.parseInt(str2[0]);
                int c = Integer.parseInt(str2[1]);

                map[r][c] = 1;
            }
            // 하나하나 방문해서, 방문했던 곳인지, 방문했던 곳이 아닌지 체크한 후에 그에 해당하는 애를 BFS 돌리면 됨
            for (int i1 = 0; i1 < M; i1++) {
                for (int j1 = 0; j1 < N; j1++) {
                    if (map[i1][j1] == 1 && !check[i1][j1]) { // map 이 1일때 배추가 심어짐, 그리고 방문하지 않았다면 새로운 지역이겠지?
                        earthWorm++;
                        bfs(i1, j1);
                    }
                }
            }

            System.out.println(earthWorm);
        }
    }
}
