package sds;

import java.io.*;
import java.util.*;

public class AlmostCircle {
    public static int[] arr;
    public static int[] choice;
    public static boolean[] visited;
    public static int N;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            arr = new int[N];
            choice = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine(), " "); // 1 3 6 8
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            choice[0] = arr[0];
            dfs(N - 1, 1);
            System.out.println("#" + (tc+1) + " " + max);
        }
    }

    private static void dfs(int depth, int idx) {
        if (idx == depth + 1) {
//            for (int i = 0; i < N; i++) {
//                System.out.print(choice[i] + " ");
//            }
//            System.out.println();
            max = Math.max(max, getMax(choice));
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[i] = arr[idx];
                dfs(depth, idx + 1);
                visited[i] = false;
            }
        }
    }

    private static int getMax(int[] choice) {
        int cnt = 0;
        for (int i = 0; i < choice.length; i++) {
            if (i == choice.length - 1) {
                int num = choice[i] + choice[0]; // 7
                if (Math.pow(Math.floor(Math.sqrt(num)), 2) == (choice[i] + choice[0])) { // 2.xx != 7
                    cnt++;
                }
            } else {
                int num = choice[i] + choice[i + 1];
                if (Math.pow(Math.floor(Math.sqrt(num)), 2) == (choice[i] + choice[i+1])) { // 2.xx != 7
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
