import java.io.*;

//백준 피보나치 수 3  10870

public class Fibonacci5_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n은 20보다 작거나 같은 자연수 또는 0이다.
		
		// 질문 왜 n+1이면 런타임 에러날까요
		int[] dp = new int[n+2];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}
}
