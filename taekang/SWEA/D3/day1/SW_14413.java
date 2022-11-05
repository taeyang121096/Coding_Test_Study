package SWEA.D3.day1;

import java.io.*;
import java.util.*;

// 상하좌우도 인가 ?
public class SW_14413 {
    private static int N, M;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 3
        for (int t = 1; t <= T; t++) {
            String[] split = br.readLine().split(" "); // 3 6

            N = Integer.parseInt(split[0]); // 3
            M = Integer.parseInt(split[1]); // 6

            // 검 0 흰 1 물음 2
            map = new int[N][M];
            for (int j = 0; j < N; j++) { // 3
                String str = br.readLine();
                for (int k = 0; k < M; k++) {
                    char ch = str.charAt(k);
                    if (ch == '#') {
                        map[j][k] = 0;
                    } else if (ch == '.') {
                        map[j][k] = 1;
                    } else {
                        map[j][k] = 2;
                    }
                }
            }

            System.out.print("#" + t + " ");

            if (isPossible(map)) System.out.println("possible");
            else System.out.println("impossible");
        }
    }

    private static boolean isPossible(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                        if (map[i][j] == 0) {
                            if (map[nr][nc] == 0) {
                                return false;
                            } else if (map[nr][nc] == 2) {
                                map[nr][nc] = 1;
                            }
                        } else if (map[i][j] == 1) {
                            if (map[nr][nc] == 1) {
                                return false;
                            } else if (map[nr][nc] == 2) {
                                map[nr][nc] = 0;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
