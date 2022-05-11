package BOJ;

//백준 파도반 수열  9461
// 일반항 : arr[n] = arr[n-2] + arr[n-3]
// 1   1   1   2   2   3   4   5   7   9
// 9 = 2 + 7
// 7 = 2 + 5
// 5 = 1 + 4

import java.io.*;

public class Padoban_BOJ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long dp[] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		int num = 0;

		for (int i = 1; i <= n; i++) {
			num = Integer.parseInt(br.readLine());
			if (num > 4) {
				for (int j = 4; j <= num; j++) {
					dp[j] = dp[j - 3] + dp[j - 2];
				}
			}
			System.out.println(dp[num]);
		}
	}
}
