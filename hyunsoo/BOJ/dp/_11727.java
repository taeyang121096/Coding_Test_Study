package BOJ.dp;
import java.util.*;
public class _11727 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int[] dp= new int[1001];

    dp[1]=1;
    dp[2]=3;

    for(int i=3; i<=1000; i++){
      dp[i]= (dp[i-1]+dp[i-2]*2)%10007;
    }

    int n =sc.nextInt();
    System.out.print(dp[n]);
  }
}
