import java.io.*;

// 백준 피보나치 함수  1003
public class Fibonacci_BOJ {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
		int n = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		
		dp[0][0] = 1; // n = 0일때 0 등장 횟수
		dp[0][1] = 0; // n = 0일때 1 등장 횟수
		dp[1][0] = 0; // n = 1일때 0 등장 횟수
		dp[1][1] = 1; // n = 1일때 1 등장 횟수
		
		// 0, 1에 대해서 연산 시작이므로 2부터 시작
		// 40 까지 저장
		for(int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][0] + " ").append(dp[num][1] + "\n");
		}
		System.out.println(sb);
	}
}
