package basic;
import java.util.*;

public class Tile {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4;i<=1000;i++){
            int count = 0;
            count += dp[i-1];
            count += dp[i-2];
            dp[i] = count%10007;
        }
        System.out.println(dp[Integer.parseInt(sc.nextLine())]);
    }
}
