package BOJ;

//백준 n과m(12) 15666
// 중복 제거
// 오름차순으로
// 조합

import java.util.*;
import java.io.*;

public class NandM12_BOJ {
	static int n, m;
	static int[] arr;
	static int[] answer;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visit = new boolean[n];
		answer = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0, 0);
		System.out.println(sb);

	}

	static void dfs(int depth, int at) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 실제 알고리즘
		int tmp = 0;
		for (int i = at; i < n; i++) {
			int now = arr[i];
			if (tmp == now) {
				continue;
			} else {
				tmp = now;
				answer[depth] = arr[i];
				dfs(depth + 1, i);
			}
		}
	}
}
