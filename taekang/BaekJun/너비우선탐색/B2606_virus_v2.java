package BaekJun.너비우선탐색;

import java.io.*;
import java.util.*;

public class B2606_virus_v2 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 7
        M = Integer.parseInt(br.readLine()); // 6
        map = new int[N+1][N+1];
        check = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String[] str = input.split(" "); // 1 2
            //map[0][1] = 1, map[1][0] = 1
            int a = Integer.parseInt(str[0]); // 1
            int b = Integer.parseInt(str[1]); // 2
            map[a ][b] = map[b][a] = 1;
        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int b = bfs(1);
        System.out.println(b);

    }

    public static int bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.offer(idx);
        check[idx] = true; // 1 번은 이미 감염
        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 1; i <= N; i++) {
                if (!check[i] && map[x][i] == 1) {
                    q.offer(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
