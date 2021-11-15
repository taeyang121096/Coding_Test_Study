package basic;

import java.util.*;

public class OneTwoThreeFive {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i =4;i<=100000;i++){
            dp[i][1] = (dp[i-1][2]+dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1]+dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1]+dp[i-3][2])%1000000009;
        }
        for(int i = 0;i<t;i++){
            int n = Integer.parseInt(sc.nextLine());
            long sum = dp[n][1]+dp[n][2]+dp[n][3];
            System.out.println(sum%1000000009);
        }
    }
}
