import java.util.*;
import java.io.*;

// 백준 2xn 타일링  11726
public class Tiling2xn_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		// 질문 왜 n+1이면 런타임 에러날까요
		int[] dp = new int[n+2];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		sb.append(dp[n]);
		
		System.out.println(sb);
	}
}
