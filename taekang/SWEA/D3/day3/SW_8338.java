package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_8338 {
    public static ArrayList<Integer> list;
    public static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            list = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
            }

            dfs(1, list.get(0));
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(int i, Integer sum) {
        if (i == N) {
            max = Math.max(max, sum);
            return;
        }
        dfs(i + 1, sum + list.get(i));
        dfs(i + 1, sum * list.get(i));
    }
}
