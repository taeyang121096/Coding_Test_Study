package BOJ;
// 백준 14501   퇴사

// n일동안 상담 가능
// t : 상담 기간 p : 상담 보상
// 1일 시작
// 1일에 3일짜리 일 -> 4일부터 시작 가능
// k일 부터 받을 수 있는 최대 금액 -> dp
// 4일 부터 받을 수 있는 최대 금액 -> p[1] + dp[4]
// 근데 dp[2]나 dp[3]이 더 크면? -> max
//dp[1] = max(p[i]+dp[i+T[i], dp[i+1])
// 상담일이 퇴사일을 초과하면 

import java.io.*;
import java.util.*;

public class LeaveJob_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[] t = new int[n+2]; // 상담 기간 -> 날짜
		int[] p = new int[n+2]; // 상담 보상
		int[] dp = new int[n+2];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n; i > 0; i--) {
			int con = i + t[i]; // i번째 상담기간
			
			if(con <= n + 1) {
				dp[i] = Math.max(p[i] + dp[con], dp[i+1]);
			} 
			// 상담 기간 초과
			else {
				dp[i] = dp[i+1]; 
			}
		}
		System.out.println(dp[1]);
	}
}
