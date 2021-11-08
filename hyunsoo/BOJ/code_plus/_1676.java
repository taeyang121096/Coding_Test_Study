package BOJ.code_plus;
import java.util.*;
public class _1676 {
  
  public static class node{
    int _2;
    int _5;
    public node(int _2, int _5){
      this._2=_2;
      this._5=_5;
    }
  }
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    node[] dp = new node[n+1];

    dp[0] = new node(0,0);

    int count2=0, count5=0;

    for(int i=1; i<=n; i++){
      if(i%2==0){
        int tmp = i/2;
        int t2 = dp[tmp]._2+1;
        int t5 = dp[tmp]._5;
        dp[i]=new node(t2,t5);
        count2+=t2;
        count5+=t5;
      }else if(i%5==0){
        int tmp = i/5;
        int t2 = dp[tmp]._2;
        int t5 = dp[tmp]._5+1;
        dp[i]=new node(t2,t5);
        count2+=t2;
        count5+=t5;
      }else{
        dp[i]=new node(0,0);
      }
    }

    System.out.println(Math.min(count2,count5));
  }
}
