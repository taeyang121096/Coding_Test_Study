import java.io.*;

// 백준 1, 2, 3 더하기  9095
public class Plus123_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t++) {
			int num = Integer.parseInt(br.readLine());
			int[] dp = new int[11];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int i = 4; i <= num; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}

			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb);
	}
}
