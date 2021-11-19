package School;
import java.util.*;
public class Tile {

    static int[] dp = new int[2000001];
    public static void main(String[]args){
       Scanner sc = new Scanner(System.in);
       int n = Integer.parseInt(sc.nextLine());
       dp[0] = 1;
       dp[1] = 1;
       dp[2] = 2;
       dp[3] = 5;
       for(int i = 4;i<=2000000;i++){
           dp[i] += (dp[i-1]*2+dp[i-3])%1000007;
       }
        System.out.println(dp[n]);

    }
}
