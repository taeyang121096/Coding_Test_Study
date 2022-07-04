class Solution {    
    public long solution(int n) {
        long dp[] = new long[n+1];
        
        if(n==1)return 1;
        if(n==2)return 2;
        dp[1] = 1;
        dp[2] = 2;
        

        for(int i = 3; in+1; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }

        
        return dp[n];
    }
}