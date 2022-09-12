package BaekJun;

import java.io.*;
import java.util.*;

/**
 * 이 문제는 ㅜ를 제외한 4개를 DFS를 사용하여 탐색하고, ㅜ를 따로 탐색해주어야 한다.
 * 그러기 위해선 방문한 점을 다시 방문하지 않게 코드를 작성해야하는데,
 * 모든 경우의 수를 전부 고려하는 알고리즘인 백트래킹을 사용한다..
 * <p>
 * BFS는 근데 백트래킹이 안된다. 재귀 기반인 DFS는 거꾸로 되돌아가는게 가능하다.. (내부적으로 스택을 사용하기때문이라는데 ..)
 */

public class B14500 {
    public static int[][] map;
    public static boolean[][] check;
    public static int N;
    public static int M;
    public static int max = Integer.MIN_VALUE;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // ㅜ ㅏ ㅓ ㅗ 모양을 각각 만들어 준 것입니다. 왼쪽 상단 기준
    public static int[][] ex = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    public static int[][] ey = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 5
        M = Integer.parseInt(st.nextToken()); // 5

        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /**
                 * 들어갔던 곳도 다시 들어가야하기 때문에 boolean을 체크해준다.
                 */
                check[i][j] = true;
                dfs(i, j, map[i][j], 1);
                check[i][j] = false;
                checkOther(i, j);
            }
        }

        System.out.println(max);
    }

    private static void checkOther(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean isOut = false;
            for (int j = 0; j < 4; j++) {
                int nr = r + ex[i][j];
                int nc = c + ey[i][j];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    isOut = true;
                    break;
                } else {
                    sum += map[nr][nc];
                }
            }
            if (!isOut) {
                max = Math.max(max, sum);
            }
        }
    }

    public static void dfs(int r, int c, int sum, int length) {
        if (length >= 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                continue;
            }

            if (!check[nr][nc]) {
                check[nr][nc] = true;
                dfs(nr, nc, sum + map[nr][nc], length + 1);
                check[nr][nc] = false;
            }
        }
    }
//    public static void bfs(int r, int c) {
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{r, c});
//        int cnt = 0;
//        int sum = map[r][c]; // 초기화
//
//        while (!q.isEmpty()) {
//            // 4가 되었을때 종료되어야 함
//            int[] tmp = q.poll();
//            for (int i = 0; i < dir.length; i++) {
//                if (cnt == 4) {
//                    System.out.println(sum);
//                    max = Math.max(max, sum);
//                    break;
//                }
//                int nr = tmp[0] + dir[i][0];
//                int nc = tmp[1] + dir[i][1];
//
//                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
//                    q.offer(new int[]{nr, nc});
//                    sum += map[nr][nc];
//                    cnt++;
//                }
//            }
//        }
//    }
}
