package Programmers;

//최단거리 - bfs
//1 -> 갈 수 있는 길
//0 -> 벽
//한칸씩 이동
//n x m 크기, 1 이상 100이하

import java.util.*;

class GameMap_Prog {

	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int x, y;
	static int nr, nc;
	static boolean[][] visit;

	public int solution(int[][] maps) {
		int answer = 0;

		n = maps.length;
		m = maps[0].length;
		visit = new boolean[n][m];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		q.offer(0);
		visit[0][0] = true;

		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();

			for (int i = 0; i < 4; i++) {
				nr = x + dx[i];
				nc = y + dy[i];
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visit[nr][nc] && maps[nr][nc] == 1) {
					q.offer(nr);
					q.offer(nc);
					maps[nr][nc] = maps[x][y] + 1;
					visit[nr][nc] = true;
				}
			}
		}
		answer = maps[n - 1][m - 1];

		if (maps[n - 1][m - 1] == 1) {
			answer = -1;
		}

		return answer;
	}
}
