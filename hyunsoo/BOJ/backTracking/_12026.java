package BOJ.backTracking;
import java.util.*;
public class _12026 {
  
  static int n;
  static String block;
  static char[] next={'B','O','J'};
  static int[] dp;
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);

    n = Integer.parseInt(sc.nextLine());
    block = sc.nextLine();
    
    dp=new int[n];
    for(int i=1; i<n; i++){
      dp[i]=Integer.MAX_VALUE;
    }

    back(0,1);
    if(dp[n-1]==Integer.MAX_VALUE) dp[n-1]=-1;
    System.out.print(dp[n-1]);
  }

  public static void back(int index, int nextblock){
    if(index== n-1){
      return;
    }
    
    for(int i=index+1; i<n; i++){
      if(block.charAt(i)==next[nextblock]){
        int en = i-index;
        if(dp[i]>dp[index]+en*en){
          dp[i]=dp[index]+en*en;
          back(i,(nextblock+1)%3);
        }
      }
    }
  }
}
