package BOJ.dp;
import java.io.*;
import java.util.*;
public class _12865 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N =Integer.parseInt(st.nextToken());
    int K =Integer.parseInt(st.nextToken());
    int[][] dp = new int[N+1][K+1];
    int[] W= new int[N+1];
    int[] V=new int[N+1];
  
    for(int i=1; i<=N; i++){
      st = new StringTokenizer(br.readLine()," ");
      W[i]=Integer.parseInt(st.nextToken());   // 무게
      V[i]=Integer.parseInt(st.nextToken());    // 가치
    }

    for(int i=1; i<=N; i++){
      for(int j=1; j<=K; j++){
        if(j<W[i]) dp[i][j]=dp[i-1][j];
        else{
          dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}
