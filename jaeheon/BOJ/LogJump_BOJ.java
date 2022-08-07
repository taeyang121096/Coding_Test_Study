package BOJ;

// 백준 11497 통나무 건너뛰기
// 통나무 건너뛰기의 난이도 : 인접한 두 통나무 간의 높이의 차의 최댓값
// 정답은 최소 난이도

import java.util.*;
import java.io.*;

public class LogJump_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[n];
			for(int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[j] = tmp;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			
			int[] tmp = new int[n];
			tmp[n/2] = arr[0];
			int cnt = 1;
			int left = n/2 - 1;
			int right = n/2 + 1;
			while(cnt < tmp.length) {
				if(right < n) {
					tmp[right++] = arr[cnt];
					cnt++;
				}
				if(left >= 0) {
					tmp[left--] = arr[cnt];
					cnt++;
				}
			}
			
			int max = Math.abs(tmp[0] - tmp[n - 1]);
			for(int j = 1; j < n; j++) {
				max = Math.max(max, (int)Math.abs(tmp[j] - tmp[j-1]));
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
