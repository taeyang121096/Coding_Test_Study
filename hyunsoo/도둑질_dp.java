public class 도둑질_dp {
  class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp = new int[money.length];
        int[] dp1 = new int[money.length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        dp[2]=dp[0]+money[2];
        
        dp1[0]=0;
        dp1[1]=money[1];
        dp1[2]=Math.max(dp1[1],money[2]);
        
        for(int i=3; i<money.length; i++){
            dp[i]=Math.max(dp[i-1],money[i]+dp[i-2]);
            dp1[i]=Math.max(dp1[i-1],money[i]+dp1[i-2]);
        }
        
        answer=Math.max(dp[money.length-2],dp1[money.length-1]);
        
        return answer;
    }
}
}
