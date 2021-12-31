package basic;

import java.util.*;
public class Stair {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[101][10];
        long mod = 1000000000;
        for(int i = 1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i =2;i<=100;i++){
            for(int j = 0;j<=9;j++){
                if(j==0){
                    dp[i][j] =dp[i-1][1]%mod;
                }else if(j<9){
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
                }
                else
                    dp[i][j] = dp[i-1][8]%mod;

            }
        }
        int n = Integer.parseInt(sc.nextLine());
        long sum = 0;
        for(int i = 0;i<=9;i++){
            sum += dp[n][i];
        }
        System.out.println(sum%mod);
    }
}
