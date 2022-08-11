package BOJ;

// 백준 11659 구간 합 구하기4

import java.util.*;
import java.io.*;

public class SectionSum_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
//		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
//			int tmp = Integer.parseInt(st.nextToken());
//			hm.put(i, tmp);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(arr[right] - arr[left - 1]).append("\n");
//			int sum = 0;
//			for(int j = left; j <= right; j++) {
//				sum+=hm.get(j);
//			}
//			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
