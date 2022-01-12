import java.io.*;
//백준 2xn 타일링 2   11727

public class Tiling2xn2_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (2*dp[i-2] + dp[i-1]) % 10007;
		}
		sb.append(dp[n]);
		
		System.out.println(sb);
	}
}
