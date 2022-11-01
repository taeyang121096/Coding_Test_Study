package SWEA.D3;

import java.io.*;
import java.util.*;

// 상하좌우도 인가 ?
public class SW_14413 {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 3
        for (int i = 1; i <= T; i++) {
            String[] split = br.readLine().split(" "); // 3 6

            N = Integer.parseInt(split[0]); // 3
            M = Integer.parseInt(split[1]); // 6

            // 검 0 흰 1 물음 2
            int[][] map = new int[N][M];
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
            System.out.print("#" + i + " ");
            // 뭐하나 옆에 다른거 or ? 이어야함
            if (isPossible(map)) {
                System.out.println("possible");
            } else {
                System.out.println("impossible");
            }
        }
    }

    private static boolean isPossible(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    if (map[i][j] == 0) {
                        if (map[i][j + 1] == 0) {
                            return false;
                        }
                    } else if (map[i][j] == 1) {
                        if (map[i][j + 1] == 1) {
                            return false;
                        }
                    }
                } else if (j == M - 1) {
                    if (map[i][j] == 0) {
                        if (map[i][j - 1] == 0) {
                            return false;
                        }
                    } else if (map[i][j] == 1) {
                        if (map[i][j - 1] == 1) {
                            return false;
                        }
                    }
                } else {
                    if (map[i][j] == 0) {
                        if (map[i][j + 1] == 0 || map[i][j - 1] == 0) {
                            return false;
                        }
                    } else if (map[i][j] == 1) {
                        if (map[i][j + 1] == 1 || map[i][j - 1] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
