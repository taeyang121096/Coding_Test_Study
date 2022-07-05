package BaekJun;

import java.io.*;
import java.util.*;

public class B16173_JumpKingJelly {
    static int[][] map;
    static boolean[][] check;
    static int N;
    static int[][] dir = {{0, 1}, {1, 0}};

    public static boolean bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        check[r][c] = true;
        //
        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // 0 , 1
            for (int[] d : dir) {
                int nr = tmp[0] + d[0]*map[tmp[0]][tmp[1]];
                int nc = tmp[1] + d[1]*map[tmp[0]][tmp[1]];
//                int nr = tmp[0];
//                int nc = tmp[1];
                // 실행 조건
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                }
                // 종료 조건

                if (nr >= 0 && nr < N && nc >= 0 && nc < N &&  map[nr][nc] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 한줄 씩 받는다
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(bfs(0,0)){
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
}

