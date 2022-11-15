package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_11315 {
    public static int N;
    public static char[][] map;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String split = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = split.charAt(j);
                }
            }
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'o') {
                        for (int k = 0; k < dir.length; k++) {
                            int c = find(i, j, k);
                            if(c == 5){
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.print("#" + tc + " ");
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static int find(int r, int c, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] check = new boolean[N][N];
        q.offer(new int[]{r, c});
        check[r][c] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int nr = tmp[0] + dir[k][0];
            int nc = tmp[1] + dir[k][1];
            if (nr >= 0 && nc >= 0 && nr < N && nc < N && !check[nr][nc] && map[nr][nc] == 'o') {
                q.offer(new int[]{nr, nc});
                check[nr][nc] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
