package codility.softeer_bootcamp;

import java.util.*;
import java.io.*;

public class Solution1 {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = str.charAt(j) - '0';
                arr[i][j] = num;
            }
        }

        dfs(0, 0, N);
    }

    public static void dfs(int x, int y, int size) {
        int num = arr[x][y];
        boolean flag = true;
        for (int i = x; i < x + size; i++) {
            if (!flag) {
                break;
            }
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.print(num);
        } else {
            System.out.print("(");
            dfs(x, y, size / 2);
            dfs(x, y + size / 2, size / 2);
            dfs(x + size / 2, y, size / 2);
            dfs(x + size / 2, y + size / 2, size / 2);
            System.out.print(")");
        }
    }
}