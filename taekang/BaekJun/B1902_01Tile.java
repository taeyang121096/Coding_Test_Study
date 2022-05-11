package BaekJun;

import java.io.*;

public class B1902_01Tile {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[1000001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // -1 로 초기화
        for(int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(N));
    }

    private static int Tile(int N) {
        if(dp[N] == -1) {
            dp[N] = (Tile(N - 1) + Tile((N - 2))) % 15746;
        }

        return dp[N];
    }
}