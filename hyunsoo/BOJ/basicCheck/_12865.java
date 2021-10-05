package BOJ.basicCheck;
import java.util.*;
public class _12865 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String[] tmp=sc.nextLine().split(" ");
    int N = Integer.parseInt(tmp[0]);
    int K = Integer.parseInt(tmp[1]);
    int[] W=new int[N+1];
    int[] V= new int[N+1];
    int[][] dp=new int[N+1][K+1];
    
    for(int i=1; i<=N; i++){
      String[] input = sc.nextLine().split(" ");
      W[i]=Integer.parseInt(input[0]);
      V[i]=Integer.parseInt(input[1]);
    }

    for(int i=1; i<=N; i++){
      for(int j=1; j<=K; j++){
        if(j<W[i]) dp[i][j]=dp[i-1][j];
        else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
      }
    }

    System.out.print(dp[N][K]);
  }
}
