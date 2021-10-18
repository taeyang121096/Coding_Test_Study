package BOJ.samsungSW;
import java.util.*;
public class _14501 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());

    int[][] arr= new int[N+1][2];
    int[] dp = new int[N+1];
    for(int i=1; i<=N; i++){
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }


    for(int i=1; i<=N; i++){
      dp[i]=Math.max(dp[i-1],dp[i]);
      
      if(i+arr[i][0]-1>N){
        continue;
      }
      dp[i+arr[i][0]-1]= Math.max(dp[i-1],Math.max(dp[i-1]+arr[i][1], dp[i+arr[i][0]-1]));
    }
    System.out.println(dp[N]);
  }
}
