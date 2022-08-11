package BOJ;

//백준 n과m(11) 15665
// 중복허용
// 모든 경우를 오름차순으로
// 대신에 같은 숫자는 신경쓰기

import java.util.*;
import java.io.*;

public class NandM11_BOJ {
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
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			int now = arr[i];
			if (tmp == now) {
				continue;
			} else {
				tmp = now;
				answer[depth] = arr[i];
				dfs(depth + 1);
			}
		}
	}
}
