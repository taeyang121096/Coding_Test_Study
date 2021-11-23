package BOJ.code_plus;
import java.util.*;
public class _1699 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] dp = new int[n+1];
    dp[1]=1;
    for(int i=2; i<=n; i++){
      for(int j=1; j*j<=i; j++){
        int tmp = j*j;
        if(dp[i]==0) dp[i] = dp[i-tmp]+1;
        else dp[i] = Math.min(dp[i], dp[i-tmp]+1);
      }
    }
    System.out.println(dp[n]);
  }
}
