package BOJ.dp;
import java.util.*;

public class _9095 {
  static int[] dp=new int[11];
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;

    int T= sc.nextInt();
    StringBuilder sb= new StringBuilder();
    for(int i=0; i<T; i++){
      int test = sc.nextInt();
      sb.append(numberSum(test)+"\n");
    }
    System.out.print(sb.toString());
  }

  public static int numberSum(int n){
    if(dp[n]!= 0) return dp[n];
    return numberSum(n-1)+numberSum(n-2)+numberSum(n-3);
  } 
}
