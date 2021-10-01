package BOJ.basicCheck;
import java.io.*;
public class _15486 {

  static int N;
  static int[][] arr;
  static int answer=0;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    arr=new int[N+2][2];
    for(int i=1; i<=N; i++){
      String[] str= br.readLine().split(" ");
      arr[i][0]=Integer.parseInt(str[0]);
      arr[i][1]=Integer.parseInt(str[1]);
    }

    int[] dp = new int[N+2];

    for(int i=1; i<N+2; i++){

      if(answer<dp[i]) answer=dp[i];

      int d= i+arr[i][0];
      if(d<N+2){
        dp[d]=Math.max(dp[d],answer+arr[i][1]);
      }
    }
    System.out.println(answer);

  }
  
}
