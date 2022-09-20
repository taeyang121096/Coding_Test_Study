package BaekJun.BruteForce;

import java.util.*;

public class B11727_2nTIle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        int[] dp = new int[num + 2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2)%10007;
        }

        System.out.println(dp[num]);
    }
}
