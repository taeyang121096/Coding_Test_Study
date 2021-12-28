package basic;
import java.util.*;
import java.io.*;
public class SumSegement {

    static int n;
    static int k;
    static int[][]dp;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String num[] = sc.nextLine().split(" ");
        n = Integer.parseInt(num[0]);
        k = Integer.parseInt(num[1]);
        dp = new int[201][201];
        for(int i = 1;i<=k;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<=k;i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[k][n]);

    }

}
