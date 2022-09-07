package Programmers;

public class Fibo_Prog {
	public int solution(int n) {
		// 0 1 1 2 3 5 8 ...
		int answer = 0;
		long[] dp = new long[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		answer = (int) dp[n];
		return answer;
	}
}
