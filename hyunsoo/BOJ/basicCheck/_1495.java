package BOJ.basicCheck;
import java.util.*;
public class _1495 {
  
  static int N,S,M;
  static int[] arr;
  static int[][] dp;
  static int answer=-1;
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    N = Integer.parseInt(input[0]);
    S = Integer.parseInt(input[1]);
    M = Integer.parseInt(input[2]);

    arr= new int[N];
    for(int i=0; i<N; i++){
      arr[i]=sc.nextInt();
    }
    dp= new int[N][M+1];

    if(S-arr[0]>=0) dp[0][S-arr[0]]=1;
    if(S+arr[0]<=M) dp[0][S+arr[0]]=1;

    for(int i=1; i<N; i++){
      for(int j=0; j<=M; j++){
        if(dp[i-1][j]==1){
          if(j-arr[i]>=0) dp[i][j-arr[i]]=1;
          if(j+arr[i]<=M) dp[i][j+arr[i]]=1;
        }
      }
    }

    for(int j=M; j>=0; j--){
      if(dp[N-1][j]==1){
        answer=j;
        break;
      } 
    }

    System.out.print(answer);
  }

}
