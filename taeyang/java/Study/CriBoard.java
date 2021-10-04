import java.util.*;
public class CriBoard {
//    n번 눌러서 a 최대 4가지 기능 1<=n<=100
    static long[]dp;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[101];
        for(int i =1;i<=6;i++)
            dp[i] = i;

        for(int i = 6;i<=100;i++){
            for(int j = 3;j<6;j++){
                dp[i] = Math.max(dp[i],dp[i-j] * (j-1));
            }
        }
        System.out.println(dp[n]);

    }
}
