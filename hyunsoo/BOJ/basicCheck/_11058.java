package BOJ.basicCheck;
import java.util.*;
public class _11058 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N= sc.nextInt();
    long[] dp = new long[N+1];

    if(N<=6) System.out.println(N);
    else{
      for(int i=1; i<=6; i++){
        dp[i]=i;
      }  
      for(int i=7; i<=N; i++){
        for(int j=1; j<=i-3; j++)
          dp[i]=Math.max(Math.max(dp[i-1]+1, dp[i-(j+2)]*(j+1)),dp[i]);
      }
      System.out.println(dp[N]);
    }

  }
}
