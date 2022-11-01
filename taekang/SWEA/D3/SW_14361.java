package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_14361 {
    private static boolean[] visited;
    private static int[] choice;
    private static int N;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String num = br.readLine();
            N = Integer.parseInt(num);
            char[] arr = num.toCharArray();
            visited = new boolean[arr.length];
            choice = new int[arr.length];
            System.out.print("#" + i + " ");
            dfs(arr, 0);
            if (cnt > 0) {
                System.out.println("possible");
            } else {
                System.out.println("impossible");
            }
            cnt = 0;
        }
    }

    private static void dfs(char[] arr, int idx) {
        if (idx == arr.length) {
            String tmp = "";
            for (int i = 0; i < choice.length; i++) {
                tmp += choice[i];
            }
            if (Integer.parseInt(tmp) % N == 0 && Integer.parseInt(tmp) / N > 1) {
                cnt++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[i] = arr[idx] - '0';
                dfs(arr, idx + 1);
                visited[i] = false;
            }
        }
    }
}
