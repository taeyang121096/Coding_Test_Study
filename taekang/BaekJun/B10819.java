package BaekJun;

import java.io.*;
import java.util.*;

public class B10819 {
    public static int N;
    public static int[] map, choice;
    static boolean[] visited;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        choice = new int[N];
        visited = new boolean[N];

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            max = Math.max(max, minus(choice));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int minus(int[] choice) {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(map[choice[i]] - map[choice[i + 1]]); //
        }
        return sum;
    }
}
