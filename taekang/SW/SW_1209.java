package SW;

import java.io.*;
import java.util.*;

public class SW_1209 {
    public static int[][] map;
    public static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 0; T < 10; T++) {
            map = new int[100][100];
            ans = new int[202];
            int N = Integer.parseInt(br.readLine()); // 1,2,3, ...
            for (int i = 0; i < 100; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[i][j]; //
                }
                ans[i] = sum;
            }

            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[j][i]; //
                }
                ans[i + 100] = sum;
            }

            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += map[i][i];
            }
            ans[200] = sum;

            int sum1 = 0;
            for (int i = 0; i < 100; i++) {
                sum1 += map[i][99 - i];
            }
            ans[201] = sum1;

            Arrays.sort(ans);
            System.out.println("#" + N + " " + ans[201]);
        }
    }
}
