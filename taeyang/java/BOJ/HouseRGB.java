package basic;

import java.util.*;
import java.io.*;

public class HouseRGB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int index = 0;
            while (st.hasMoreTokens()) {
                arr[i][index++] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            for(int j = 0;j<3;j++){
                if(k == j)
                    dp[1][j] = arr[0][j];
                else
                    dp[1][j] = 1000001;
            }
            for (int i = 2; i <= n; i++) {
                dp[i][0] = arr[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = arr[i - 1][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = arr[i - 1][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
            }
            for(int i = 0;i<3;i++)
                if(i!= k && min>dp[n][i])
                    min = dp[n][i];
        }
        System.out.println(min);

    }
}
