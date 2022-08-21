package BOJ;

// 백준 17086 아기상어2
// 안전거리 : 0인칸에서 1인칸까지 거리의 최대

import java.util.*;
import java.io.*;

public class BabyShark2_BOJ {
	static int n;
	static int m;
	static int[][] arr;
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					continue;
				}
				max = bfs(i, j);
				answer = Math.max(answer, max);
			}
		}
		System.out.println(answer);
	}

	static int bfs(int r, int c) {
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c, 0 });
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = now[0] + dx[i];
				int nc = now[1] + dy[i];
				int tmp = now[2];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc]) {
					continue;
				}
				if (arr[nr][nc] == 1) {
					return tmp + 1;
				}
				visit[nr][nc] = true;
				q.offer(new int[] { nr, nc, tmp + 1 });
			}
		}
		return 0;
	}
}
