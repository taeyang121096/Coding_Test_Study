package basic;
import java.util.*;
public class Card {

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] p = new int[n+1];
        int idx = 1;
        for(String str : sc.nextLine().split(" ")){
            p[idx++] = Integer.parseInt(str);
        }
        int[] dp = new int[n+1];
        dp[1] = p[1];
        for(int i = 2;i<=n;i++){
            int val = p[i];
            for(int j=1;j<=i/2;j++){
                val = Math.max(dp[j]+dp[i-j],val);
            }
            dp[i] = val;
        }


        System.out.println(dp[n]);
    }
}
