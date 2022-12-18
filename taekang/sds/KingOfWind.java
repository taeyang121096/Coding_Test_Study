package sds;

import java.io.*;
import java.util.*;

public class KingOfWind {
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int[] choice;
    public static int max;
    public static int N, M, K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 5
            M = Integer.parseInt(st.nextToken()); // 5
            K = Integer.parseInt(st.nextToken()); // 3
            max = Integer.MIN_VALUE;
            choice = new int[K];

            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, map);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[][] map) {
        if (K == depth) {
            getMax(map, choice);
            return;
        }

        for(int i = 0; i < 4; i++) {
            choice[depth] = i;
            dfs(depth + 1, map);
        }
    }

    private static void getMax(int[][] map, int[] choice) { // 000
        for(int idx = 0; idx < choice.length; idx++) {
            // 북풍 idx == 1
            if(choice[idx] == 1){
                int start_row = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {

                    }
                }
            }
            // 서풍 idx == 2
            else if(choice[idx] == 2){
                int start_col = 0;
            }
            // 동풍 idx == 3
            else if(choice[idx] == 3){
                int start_col = M-1;
            }
            // 남풍 idx == 0
            else {
                int start_row = N-1;
            }
        }
    }
}
