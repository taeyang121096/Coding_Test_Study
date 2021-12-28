package basic;

import java.util.*;
public class MakeOne {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4;i<=1000000;i++){
            int val = Integer.MAX_VALUE;
            if(i%2 == 0){
                val = Math.min(dp[i/2]+1,val);

            }
            if(i%3 == 0){
                val = Math.min(val,dp[i/3]+1);

            }
            val  = Math.min(dp[i-1] +1,val);
            dp[i] = val;
        }
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(dp[n]);
    }
}
