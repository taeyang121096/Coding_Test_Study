package BaekJun;

import java.io.*;
import java.util.*;


public class B1182 {
    public static int N, S;
    public static int[] map;
    public static int cnt = 0;
    public static int[] choice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        // -7 -3 -2 5 8
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            choice = new int[i];
            dfs(i, 0, 0);
        }
        System.out.println(cnt);
    }

    private static void dfs(int depth, int idx, int at) {
        if (depth == at) {
            int sum = 0;
            for (int i = 0; i < choice.length; i++) {
                sum += choice[i];
            }
            if (sum == S) {
                cnt++;
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            choice[at] = map[i];
            dfs(depth, i + 1, at + 1);
        }
    }
}
