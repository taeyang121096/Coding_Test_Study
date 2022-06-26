package Programmers;

//한번에 1 or 2
//뛸 수 있는 모든 경우의 수 리턴
//n은 1이상 2000이하

class LongJump_Prog {
	public long solution(int n) {

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] += (dp[i - 2] + dp[i - 1]) % 1234567;
		}

		return dp[n];
	}
}
