package basic;

import java.util.*;
public class ASC {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        dp = new int[n+1][10];
        for(int i = 0;i<10;i++)
            dp[1][i] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<10;j++){
                for(int k = 0;k<=j;k++)
                    dp[i][j] += dp[i-1][k]%10007;
            }
        }
        System.out.println(Arrays.stream(dp[n]).sum()%10007);
    }
}
