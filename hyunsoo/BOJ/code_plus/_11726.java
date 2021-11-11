package BOJ.code_plus;
import java.util.*;
public class _11726 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n+1];
    dp[0]=1;
    dp[1]=1;
    
    if(n>1){
      for(int i=2; i<=n; i++){
        dp[i]=(dp[i-2]+dp[i-1])%10007;
      }
    }
    System.out.println(dp[n]);

  }
}
