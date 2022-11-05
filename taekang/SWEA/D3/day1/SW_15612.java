package SWEA.D3.day1;

import java.io.*;
import java.util.*;

public class SW_15612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 3
        for (int i = 0; i < T; i++) {
            String[][] map = new String[8][8];
            int cnt = 0;
            for (int j = 0; j < 8; j++) {
                String[] split = br.readLine().split("");
                for (int k = 0; k < 8; k++) {
                    map[j][k] = split[k];
                    if (split[k].equals("O")) cnt++;
                }
            }
            System.out.print("#" + (i+1) + " ");
            if (cnt != 8) {
                System.out.println("no");
            } else {
                if (isPossible(map)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    private static boolean isPossible(String[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].equals("O")) {
                    // 행, 열 에 다른 O 가 있나 없나 확인, map[0][7]
                    // map[0][1~7], map[1~7][7]
                    for (int k = 0; k < 8; k++) {
                        if (j != k) {
                            if (map[i][k].equals("O")) {
                                return false;
                            }
                        }
                    }
                    for (int k = 0; k < 8; k++) {
                        if (i != k) {
                            if (map[k][j].equals("O")) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
