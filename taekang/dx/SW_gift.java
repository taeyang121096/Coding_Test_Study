package dx;

import java.io.*;
import java.util.*;

/**
 * 1행 1열부터 R행 C열까지 있다. R*C 개의 도시
 * 여행 첫날 1행 1열, A부터 Z 중 하나의 알파벳으로 나타낼 수 있는 기념품이 있고 같은 알파벳은 같은 기념품이다.
 * <p>
 * 도시에 도착할 때마다 기념품
 * 기념품을 최대한 많이 구매하되, 종류가 겹치지 않도록 여행 경로를 계획하고싶다.
 */
public class SW_gift {
    public static int R, C;
    public static char[][] map;
    public static int max;
    public static boolean[][] visited;
    public static HashSet<Character> set;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void dfs(int r, int c, int level) {
        visited[r][c] = true;
        max = Math.max(max, level);
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
                if (!set.contains(map[nr][nc])) {
                    set.add(map[nr][nc]);
                    dfs(nr, nc, level + 1);
                    visited[nr][nc] = false;
                    set.remove(map[nr][nc]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            set = new HashSet<>();
            map = new char[R][C];
            visited = new boolean[R][C];
            max = Integer.MIN_VALUE;

            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            set.add(map[0][0]);
            dfs(0, 0, 1);

            System.out.println("#" + t + " " + max);
        }
    }
}
