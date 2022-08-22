package SW;

import java.io.*;
import java.util.*;

public class SW_1226 {
    public static int[][] map;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            map = new int[16][16];
            int N = Integer.parseInt(br.readLine()); // 1..2..
            for (int i = 0; i < 16; i++) {
                String str = br.readLine(); //
                for (int j = 0; j < 16; j++) {
                    map[i][j] = str.charAt(j) - 48; //
                }
            }

//            for (int i = 0; i < 16; i++) {
//                for (int j = 0; j < 16; j++) {
//                    System.out.println(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if(map[i][j] == 2){
                        if(bfs(i, j)){
                            System.out.println("#" + N + " " + 1);
                            break;
                        } else {
                            System.out.println("#" + N + " " + 0);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean bfs(int r, int c) {
        boolean[][] check = new boolean[16][16];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        check[r][c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int[] d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];

                if(nr >=0 && nc >= 0 && nr <=16 && nc <= 16 && !check[nr][nc] && map[nr][nc] == 0){
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                } else if (nr >= 0 && nc >= 0 && nr <= 16 && nc <= 16 && !check[nr][nc] && map[nr][nc] == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
