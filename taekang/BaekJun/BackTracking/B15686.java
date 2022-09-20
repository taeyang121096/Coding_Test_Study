package BaekJun.BackTracking;

import java.io.*;
import java.util.*;

public class B15686 {
    public static int[][] map;
    public static int[] choice;
    public static int N, M;
    public static int answer = Integer.MAX_VALUE;
    public static ArrayList<int[]> chicken = new ArrayList<>();
    public static ArrayList<int[]> house = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 5
        M = Integer.parseInt(st.nextToken()); // 3
        choice = new int[M];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chicken.add(new int[]{i, j});
                else if (map[i][j] == 1) house.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int at) {
        if (depth == M) {
            int tmp = 0;
            for (int i = 0; i < house.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < choice.length; j++) {
                    distance =
                            Math.min(Math.abs(chicken.get(choice[j])[0] - house.get(i)[0]) + Math.abs(chicken.get(choice[j])[1] - house.get(i)[1]), distance);
                }
                tmp += distance;
            }

            answer = Math.min(tmp, answer);
            return;
        }
        for (int i = at; i < chicken.size(); i++) {
            choice[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}

/**
 * i = 0, depth = 0 choice[0] = 0
 * dfs(1, 1);
 * <p>
 * i = 1, depth = 1 choice[1] = 1;
 * dfs(2,2); // return
 * i = 2, choice[1] = 2;
 * dfs(2,3); // return
 * i = 3, choice[1] = 3;
 * dfs(2,4); // return
 * i = 4, choice[1] = 4;
 * <p>
 * i = 1, depth = 0 choice[0] = 1
 */