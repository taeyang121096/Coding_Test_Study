package BOJ.basicCheck;
import java.util.*;
public class _15989 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(sc.nextLine());


    int[][] dp = new int[10001][4];
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1+1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1+1+1
		dp[3][2] = 1; // 1+2
		dp[3][3] = 1; // 3
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}

    for(int i=0; i<T; i++){
      int tmp = Integer.parseInt(sc.nextLine());
      sb.append(dp[tmp][1]+dp[tmp][2]+dp[tmp][3]+"\n");
    }
    System.out.println(sb.toString());
  }


}
