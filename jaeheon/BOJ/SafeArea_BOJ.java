package BOJ;

// 백준 2468 안전영역

import java.util.*;
import java.io.*;

public class SafeArea_BOJ {

	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];

		int max = 0;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		int answer = 0;
		for (int h = 1; h <= max; h++) {
			visit = new boolean[n + 1][n + 1];
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (!visit[i][j] && arr[i][j] >= h) {
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	static void dfs(int r, int c, int height) {
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr < 1 || nc < 1 || nr > n || nc > n) {
				continue;
			}
			if (nr >= 1 && nc >= 1 && nr <= n && nc <= n && !visit[nr][nc] && arr[nr][nc] >= height) {
				visit[nr][nc] = true;
				dfs(nr, nc, height);
			}
		}
	}
}
