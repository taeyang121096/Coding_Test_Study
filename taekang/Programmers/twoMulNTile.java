//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        int[] dp = new int[60001];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i = 3; i < dp.length; i++){
//            int num = dp[i-1] + dp[i-2];
//            dp[i] = num % 1000000007;
//        }
//        return dp[n];
//        // n = 1, 1가지
//        // n = 2, 2가지
//        // n = 3, 3가지
//        // n = 4, 5가지
//        // n = 5,
//    }
//}