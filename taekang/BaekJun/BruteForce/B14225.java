package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B14225 {
    public static int N;
    public static int[] S;
    public static boolean[] check;
    public static int[] choice;
    public static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new boolean[2000001]; // 0 ~ 2000001
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 3
        S = new int[N]; // {5,1,2}
        check = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken()); // 5 1 2
            arr[S[i]] = true;
        }

        for (int i = 2; i <= N; i++) {
            choice = new int[i];
            dfs(0, 0, i);
        }

        for (int i = 1; i < 2000000; i++) {
            if (!arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void dfs(int sum, int idx, int depth) {
        if (depth == idx) {
            arr[sum] = true;
            return;
        }
        dfs(sum, idx + 1, depth);
        dfs(sum + S[idx], idx + 1, depth);
    }
}
