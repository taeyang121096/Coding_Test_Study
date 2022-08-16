package SW;

import java.io.*;
import java.util.*;

public class SW_1211 {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}};
    public static int arr[][];
    public static int ans[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 0; T < 10; T++) {
            arr = new int[100][100]; // 사다리 값이 들어가는 배열
            ans = new int[100]; // 정답 배열
            int N = Integer.parseInt(br.readLine()); // 1

            for (int i = 0; i < 100; i++) {
                String[] str = br.readLine().split(" "); // 한줄 다 받고
                for (int j = 0; j < str.length; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int j = 0; j < 100; j++) { // arr의 첫번째 배열을 해야하니까
                if (arr[0][j] == 1) { // j = 0
                    int cnt = bfs(0, j); // c

                    ans[j] = cnt;
                }
            }

            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < 100; i++) {
                if (ans[i] != 0) {
                    if (min >= ans[i]) {
                        min = ans[i];
                        idx = i;
                    }
                }
            }

            System.out.println("#" + N + " " + idx);
        }
    }

    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[100][100];
        q.offer(new int[]{r, c}); // 0 1
        check[r][c] = true; //
        int cnt = 0; //

        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // 0 1
            // 종료조건

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && !check[nr][nc] && arr[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
