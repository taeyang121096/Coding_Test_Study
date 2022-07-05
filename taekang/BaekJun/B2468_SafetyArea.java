package BaekJun;

import java.io.*;
import java.util.*;

/**
 * 물에 잠기지 않는 안전한 영역이 최대호 몇 개가 만들어 지는가
 * 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정
 * 2차원 배열, 각 원소는 해당 지점의 높이 표시하는 자연수
 * 안전한 영역의 최대 개수를 구하는 프로그램
 * 아무 지역도 물에 안 잠길 수 있음
 */
public class B2468_SafetyArea {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int max = Integer.MIN_VALUE;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 5
        map = new int[N][N];

        int map_max = -1;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] > map_max){
                    map_max = map[i][j];
                }
            }
        }
        int cnt = 0;
        // 그냥 100번 돌려보자
        // 그대신 다 잠기면 개수가 0나오겠지? 0 나오는 순간 break를 걸어버려
        for (int k = 0; k <= map_max; k++) {
            check = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !check[i][j]){
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }


    private static void bfs(int i, int j, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        check[i][j] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            // 종료 조건

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && (map[nr][nc] > k)) {
                    check[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
