package BOJ;

// 백준 1912 연속합

import java.io.*;
import java.util.*;

public class ContinuousSum_BOJ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum+=num;
			max = Math.max(max, sum);
			if(sum < 0) {
				sum = 0;
			}
		}
		sb.append(max).append("\n");
		System.out.println(sb.toString());
	}
}
