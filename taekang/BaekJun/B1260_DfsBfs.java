package BaekJun;

import java.io.*;
import java.util.*;

public class B1260_DfsBfs {

    static int[][] map;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] s = input.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        isUsed = new boolean[1001];
        map = new int[1001][1001];

        // 간선 정보 저장하는 반복문
        for (int i = 0; i < M; i++) {
            String input2 = br.readLine();
            String[] s1 = input2.split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);

            map[x][y] = map[y][x] = 1;
        }

        dfs(N, V);
        isUsed = new boolean[1001]; // 초기화
        System.out.println();
        bfs(N, V); // N, 1
    }

    public static void dfs(int N, int i) {
        isUsed[i] = true;
        System.out.print(i + " ");
        for (int j = 1; j < N + 1; j++) {
            if(map[i][j] == 1 && isUsed[j] == false)
                dfs(N, j);
        }
    }

    // if bfs(4,1)
    public static void bfs(int N, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 1, {f,f,f,f}
        isUsed[start] = true; // 1, {t,f,f,f}
        System.out.print(start + " "); // sout(1)

        while (!queue.isEmpty()) {
            int temp = queue.poll(); // temp = 1,

            for (int j = 1; j < N + 1; j++) {
                if (map[temp][j] == 1 && isUsed[j] == false) { // map[1][0..N] == 1&& isUsed[0..N] == false
                    queue.offer(j); // 2, {t,f,f,f} -> 2,3 {t,t,f,f} -> 2,3,4 {t,t,t,f}
                    isUsed[j] = true; // 2, {t,t,f,f} -> 2,3 {t,t,t,f} -> 2,3,4 {t,t,t,t}
                    System.out.print(j + " "); // sout(1,2) -> sout(1,2,3) -> sout(1,2,3,4)
                }
            }
        }
    }
}
