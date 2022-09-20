package BaekJun.너비우선탐색;

import java.io.*;
import java.util.*;

public class B2667_danji {
    static int N;
    static int buildNum = 0;
    static int[][] map;
    static boolean[][] check;
    static int[] buildings;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N + 1][N + 1];
        buildings = new int[N * N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !check[i][j]){
                    buildNum++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(buildings);
        System.out.println(buildNum);

        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i] == 0) {
                continue;
            } else {
                System.out.println(buildings[i]);
            }
        }
    }

    static void bfs(int i, int j){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        q.offer(new int[]{i, j});
        check[i][j] = true;
        buildings[buildNum]++;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int[] dr : dir) {
                int nr = tmp[0] + dr[0];
                int nc = tmp[1] + dr[1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && check[nr][nc] == false && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                    buildings[buildNum]++;
                }
            }
        }
    }
}
