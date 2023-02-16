package Programmers;

import java.util.*;

public class MiroEscape_Prog {
	static boolean[][] visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;
	static int startX;
	static int startY;
	static int labberX;
	static int labberY;
	static int endX;
	static int endY;
	static char[][] map;

	public int solution(String[] maps) {
		int answer = 0;

		n = maps.length;
		m = maps[0].length();
		visit = new boolean[n][m];
		map = new char[maps.length][maps[0].length()];
		for (int i = 0; i < maps.length; i++) {
			String str = maps[i];
			for (int j = 0; j < maps[i].length(); j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if (ch == 'S') {
					startX = i;
					startY = j;
				}
				if (ch == 'L') {
					labberX = i;
					labberY = j;
				}
				if (ch == 'E') {
					endX = i;
					endY = j;
				}
			}
		}

		int first = bfs1();
		int second = bfs2();
		if (first == -1 || second == -1) {
			return -1;
		}

		answer = first + second;

		return answer;
	}

	static int bfs1() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { startX, startY, 0 });
		visit[startX][startY] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dx[i];
				int nc = tmp[1] + dy[i];
				int cost = tmp[2];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 'X' || visit[nr][nc]) {
					continue;
				}
				q.offer(new int[] { nr, nc, cost + 1 });
				visit[nr][nc] = true;
				if (map[nr][nc] == 'L') {
					return cost + 1;
				}
			}
		}
		return -1;
	}

	static int bfs2() {
		visit = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { labberX, labberY, 0 });
		visit[labberX][labberY] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dx[i];
				int nc = tmp[1] + dy[i];
				int cost = tmp[2];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 'X' || visit[nr][nc]) {
					continue;
				}
				q.offer(new int[] { nr, nc, cost + 1 });
				visit[nr][nc] = true;
				if (map[nr][nc] == 'E') {
					return cost + 1;
				}
			}
		}
		return -1;
	}
}
