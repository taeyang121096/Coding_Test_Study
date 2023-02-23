package Programmers;

import java.util.*;

public class RacingTrack_Prog {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][][] arr;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static int n;

	public int solution(int[][] board) {
		n = board.length;
		arr = new int[4][n][n];
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		bfs(0, 0);

		return answer;
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 1, 0 });
		q.offer(new int[] { 0, 0, 3, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dx[i];
				int nc = tmp[1] + dy[i];
				int cost = tmp[3];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] == 1) {
					continue;
				}

				if (tmp[2] != i) {
					if (arr[i][nr][nc] < cost + 600) {
						continue;
					}
					arr[i][nr][nc] = cost + 600;
					q.offer(new int[] { nr, nc, i, cost + 600 });
				} else {
					if (arr[i][nr][nc] < cost + 100) {
						continue;
					}
					arr[i][nr][nc] = cost + 100;
					q.offer(new int[] { nr, nc, i, cost + 100 });
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			answer = Math.min(arr[i][n - 1][n - 1], answer);
		}
	}
}
