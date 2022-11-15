package codility;

import java.io.*;
import java.util.*;

public class Softeer_test1 {
    public static int cnt = 0;
    public static int lines;
    public static int[][] area;
    public static boolean[][] visited;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = Integer.parseInt(br.readLine());

        area = new int[lines][lines];
        visited = new boolean[lines][lines];

        for (int i = 0; i < lines; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                area[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (area[i][j] == 1 && !visited[i][j]) {
                    int bfs = bfs(i, j, 0);
                    cnt++;
                    list.add(bfs);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for (Integer in : list) {
            System.out.print(in + " ");
        }
    }

    public static int bfs(int r, int c, int cost) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, cost});
        visited[r][c] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                int dep = tmp[2];
                if (nr >= 0 && nc >= 0 && nr < lines && nc < lines && area[nr][nc] == 1 && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc, dep + 1});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}