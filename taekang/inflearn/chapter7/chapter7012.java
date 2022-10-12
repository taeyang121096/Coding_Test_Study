package inflearn.chapter7;

import java.io.*;
import java.util.*;

public class chapter7012 {
    public static int N, M, answer = 0;
    public static int[][] map;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        check[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int V) {
        if (V == N) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (map[V][i] == 1 && !check[i]) {
                    check[i] = true;
                    dfs(i);
                    check[i] = false;
                }
            }
        }
    }
}
