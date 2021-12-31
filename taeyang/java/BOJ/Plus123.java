package basic;
import java.util.*;
public class Plus123 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i =4;i<=1000000;i++)
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) %1000000009;
        int t = Integer.parseInt(sc. nextLine());
        for(int i = 0;i<t;i++){
            System.out.println(dp[Integer.parseInt(sc.nextLine())]);
        }
    }
}
