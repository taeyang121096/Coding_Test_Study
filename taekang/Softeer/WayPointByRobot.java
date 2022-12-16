package Softeer;

import java.util.*;
import java.io.*;

/**
 * L : 로봇이 왼쪽으로 90도 회전, 방향 바뀜
 * R : 로봇이 오른쪽으로 90도 회전, 방향 바뀜
 * A : 앞으로 2칸이동, 격자판 나가면 명령 수행 불가
 * <p>
 * 사수가 로봇이 같은 칸을 두번 이상 방문하지 못하도록 함, 출발칸 포함
 * <p>
 * 1. 처음 로봇을 어떤 칸에, 어떤 방향 으로 두어야 하는가 ?
 * 2. 이후 로봇에 어떤 명령어를 어떤 순서대로 입력해야 하는가 ?
 **/
public class WayPointByRobot {
    public static char start = ' ';
    public static int a, b;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // > < v ^
    public static char[] st_arr = {'>', 'v', '<', '^'};
    public static StringBuilder sb = new StringBuilder();

    public static void bfs(int r, int c, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, idx}); // 0, 7, 0

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // 0, 7, 0
            int cp_cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nr = tmp[0] + dir[k][0];
                int nc = tmp[1] + dir[k][1];
                int go_idx = tmp[2];

                if (nr >= 0 && nc >= 0 && nr < a && nc < b && !visited[nr][nc] && map[nr][nc] == '#') {
                    cp_cnt++;
                    if (go_idx == k) {
                        q.offer(new int[]{nr, nc, go_idx});
                        cnt++;
                    } else {
                        if ((go_idx == 3 && k == 0) || (go_idx == 0 && k == 3)) {
                            if (go_idx == 3 && k == 0) {
                                for (int i = 0; i < cnt / 2; i++) {
                                    sb.append("A");
                                }
                                cnt = 1;
                                sb.append("R");
                            } else {
                                for (int i = 0; i < cnt / 2; i++) {
                                    sb.append("A");
                                }
                                cnt = 1;
                                sb.append("L");
                            }
                        } else {
                            if (go_idx < k) {
                                for (int i = 0; i < cnt / 2; i++) {
                                    sb.append("A");
                                }
                                cnt = 1;
                                sb.append("R");
                            } else {
                                for (int i = 0; i < cnt / 2; i++) {
                                    sb.append("A");
                                }
                                cnt = 1;
                                sb.append("L");
                            }
                        }
                        q.offer(new int[]{nr, nc, k});
                    }
                    visited[nr][nc] = true;
                }
            }
            if (cp_cnt == 0) {
                for (int i = 0; i < cnt / 2; i++) {
                    sb.append("A");
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken()); // 5
        b = Integer.parseInt(st.nextToken()); // 8
        map = new char[a][b];
        visited = new boolean[a][b];

        for (int i = 0; i < a; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < b; j++) {
                map[i][j] = str[j].charAt(0);
            }
        }

        int start_idx_r = 0;
        int start_idx_c = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int num = -1;
                int cnt = 0;
                if (!visited[i][j] && map[i][j] == '#') {
                    // System.out.println(i + " " + j);
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dir[k][0];
                        int nc = j + dir[k][1];
                        if (nr >= 0 && nc >= 0 && nr < a && nc < b && !visited[nr][nc] && map[nr][nc] == '#') {
                            cnt++;
                            start = st_arr[k];
                            num = k;
                            start_idx_r = i;
                            start_idx_c = j;
                        }
                    }
                }
                if (cnt == 1) {
//                    System.out.println(i + " " + j);
                    visited[i][j] = true;
                    bfs(i, j, num);
                    break;
                }
            }
        }

         System.out.println((start_idx_r + 1) + " " + (start_idx_c + 1));
         System.out.println(start);
         System.out.println(sb.toString());
    }
}