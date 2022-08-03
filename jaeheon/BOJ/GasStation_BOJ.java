package BOJ;

// 백준 13305 주유소
// 도시간 거리 : 1이상 1,000,000,000 이하
// 리터당 가격 : 1이상 1,000,000,000 이하 -> long

import java.util.*;
import java.io.*;

public class GasStation_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] length = new int[n-1];
		for(int i = 0; i < n-1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] cost = new int[n];
		for(int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0L;
		long now = Integer.MAX_VALUE;
		for(int i = 0; i < n - 1; i++) {
			now = Math.min(now, cost[i]);
			answer += now*length[i];
		}
		System.out.println(answer);
	}
}
