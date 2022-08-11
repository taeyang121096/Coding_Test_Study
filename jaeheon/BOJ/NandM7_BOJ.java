package BOJ;

//백준 n과m(6) 15655

import java.util.*;
import java.io.*;

public class NandM7_BOJ {
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
		answer = new int[n];
		visit = new boolean[n];

		// 3 3
		// 1 2 3
		// 4 5 6
		// 7 8 9

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);

	}

	static void dfs(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 실제 알고리즘
		for (int i = 0; i < n; i++) {
			answer[depth] = arr[i];
			dfs(depth + 1);

		}
	}

}
