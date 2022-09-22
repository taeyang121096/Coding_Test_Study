package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B15661 {
    public static int N, min = Integer.MAX_VALUE;
    public static int[][] map;
    public static int[] start;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 4
        map = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            start = new int[i];
            dfs(0, 0, i);
        }

        System.out.println(min);
    }

    public static void dfs(int at, int depth, int idx) {
        if (idx == depth) {
            min = Math.min(min, sumTeam());
            return;
        }
        // at을 사용하여 i+1을 해줘야한다!!
        for (int i = at; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                start[depth] = i;
                dfs(i + 1, depth + 1, idx);
                check[i] = false;
            }
        }
    }

    public static int sumTeam() {
        ArrayList<Integer> link = new ArrayList<>();

        boolean[] isLink = new boolean[N]; // t t f f
        for (int i = 0; i < start.length; i++) {
            isLink[start[i]] = true;
        }
        for (int i = 0; i < isLink.length; i++) {
            if (!isLink[i]) {
                link.add(i);
            }
        }

        int start_sum = 0;
        if (start.length == 1) {
            start_sum = 0;
        } else {
            for (int i = 0; i < start.length; i++) { // 0, 1
                for (int j = i + 1; j < start.length; j++) { // 1,
                    start_sum += map[start[i]][start[j]] + map[start[j]][start[i]];
                }
            }
        } // 0 1 2 4

        int link_sum = 0;
        if (link.size() == 1) {
            link_sum = 0;
        } else {
            for (int i = 0; i < link.size(); i++) { // 0, 1
                for (int j = i + 1; j < link.size(); j++) { // 1,
                    link_sum += map[link.get(i)][link.get(j)] + map[link.get(j)][link.get(i)];
                }
            }
        }

        return Math.abs(link_sum - start_sum);
    }
}
