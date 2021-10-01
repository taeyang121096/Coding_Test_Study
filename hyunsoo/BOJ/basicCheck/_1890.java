package BOJ.basicCheck;
import java.io.*;
public class _1890 {
  static int[][] arr;
  static int N;
  static int answer=0;
  static long[][] dp;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    
    arr=new int[N+1][N+1];
    dp=new long[N+1][N+1];

    for(int i=1; i<=N; i++){
      String[] str= br.readLine().split(" ");
      for(int j=0; j<N; j++){
        arr[i][j+1]=Integer.parseInt(str[j]);
      }
    } 
    
    dp[1][1]=1;

    for(int i=1; i<=N; i++){
      for(int j=1; j<=N; j++){
        if(dp[i][j]==0 || i==N && j==N) continue;

        int move = arr[i][j];
        int x= i+move;
        int y= j+move;

        if(x<=N){
          dp[x][j]+=dp[i][j];
        }
        if(y<=N){
          dp[i][y]+=dp[i][j];
        }
      }
    }

    
    System.out.println(dp[N][N]);
  }
}
