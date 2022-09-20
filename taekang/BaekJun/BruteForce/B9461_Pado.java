package BaekJun.BruteForce;

import java.io.*;

public class B9461_Pado {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        // -1 로 초기화
        for (int i = 6; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(Pado(N));
        }
    }

    static long Pado(int n) {
        if (dp[n] == -1) {
            dp[n] = Pado(n - 1) + Pado(n - 5);
        }

        return dp[n];
    }
}
