package BaekJun;

import java.io.*;
import java.util.StringTokenizer;

public class B1149_RGBDistance {
    static int[][] dp,cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][3];
        cost = new int[N + 1][3];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 26
            cost[i][1] = Integer.parseInt(st.nextToken()); // 40
            cost[i][2] = Integer.parseInt(st.nextToken()); // 83
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        int ans = dp[N][0];

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[dp.length - 1][i]);
        }

        System.out.println(ans);
    }
}
