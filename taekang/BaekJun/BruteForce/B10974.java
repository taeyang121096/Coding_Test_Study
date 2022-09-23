package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B10974 {
    public static int N;
    public static int[] choice;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        choice = new int[N];
        check = new boolean[N];
        dfs(0, 0);
    }

    public static void dfs(int depth, int at) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(choice[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                choice[depth] = i + 1;
                dfs(depth + 1, i + 1);
                check[i] = false;
            }

        }
    }
}
