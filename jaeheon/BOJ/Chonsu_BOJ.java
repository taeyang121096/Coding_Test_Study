package BOJ;

// 백준 2644 촌수계산

import java.util.*;
import java.io.*;

public class Chonsu_BOJ {

	static int[][] arr;
	static int n, m;
	static int start, end;
	static boolean[] visit;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		answer = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		bfs(start, end);

		if (answer[end] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer[end]);
		}
	}

	static void bfs(int r, int c) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(r);
		visit[r] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			if(now == end) {
				break;
			}
			for (int i = 1; i <= n; i++) {
				if (arr[now][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
					answer[i] = answer[now] + 1;
				}
			}
		}
	}
}
