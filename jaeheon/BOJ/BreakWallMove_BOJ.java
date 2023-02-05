package BOJ;

import java.util.*;
import java.io.*;

public class BreakWallMove_BOJ {

    static int n, m;
    static int[][] arr;
    static int[][] cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        cnt = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    arr[i][j] = 1;
                }
                if(!(i == 0 && j == 0)){
                    cnt[i][j] = n * m;
                }
            }
        }

        if(n == 1 && m == 1){
            System.out.println(1);
        } else {
            System.out.println(bfs(0, 0));
        }
    }

    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0, 1});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dx[i];
                int nc = tmp[1] + dy[i];
                int bomb = tmp[2];
                int cost = tmp[3];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                if (nr == n - 1 && nc == m - 1) {
                    return cost + 1;
                }
                if (cnt[nr][nc] > bomb) {
                    if(arr[nr][nc] == 1){
                        if (bomb == 0) {
                            q.offer(new int[]{nr, nc, bomb + 1, cost + 1});
                            cnt[nr][nc] = bomb + 1;
                        }
                    } else {
                        q.offer(new int[]{nr, nc, bomb, cost + 1});
                        cnt[nr][nc] = bomb;
                    }
                }
            }
        }
        return -1;
    }
}
