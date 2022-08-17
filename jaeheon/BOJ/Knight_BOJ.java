package BOJ;

// 백준 7562 나이트의 이동

import java.util.*;
import java.io.*;

public class Knight_BOJ {
	static int[][] mat;
	static boolean[][] visit;
	static int n;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for (int i = 0; i < 8; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visit[nr][nc]) {
					visit[nr][nc] = true;
					mat[nr][nc] += mat[x][y] + 1;
					q.offer(new int[] { nr, nc });
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			mat = new int[n][n];
			visit = new boolean[n][n];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int nr = Integer.parseInt(st.nextToken());
			int nc = Integer.parseInt(st.nextToken());
			
			bfs(r, c);
			sb.append(mat[nr][nc]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
