import java.util.*;
import java.io.*;

public class Image_softeer {


// dir = 상 하 좌 우
// bfs를 통해서 mat 값을 하나씩 변화 시킨다(change), origin
// q 횟수만큼 진행


    static int[][] mat;
    static int h;
    static int w;
    static int change;
    static int origin;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void bfs(int r, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            mat[tmp[0]][tmp[1]] = change;
            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                if (nr < h && nr >= 0 && nc < w && nc >= 0 && mat[nr][nc] == origin)
                    q.offer(new int[]{nr, nc});
            }

        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        mat = new int[h][w];
        for (int i = 0; i < h; i++) {
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                mat[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int cate = 1;
        int val = mat[0][0];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (val != mat[i][j])
                    cate++;
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            change = Integer.parseInt(st.nextToken());
            origin = mat[r][c];
            if (change == origin)
                continue;
            if (cate == 1) {
                val = change;
                continue;
            }
            bfs(r, c);
        }
        if (cate == 1) {
            for (int[] i : mat) {
                Arrays.fill(i, val);
            }
        }
        for (int[] i : mat) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}

