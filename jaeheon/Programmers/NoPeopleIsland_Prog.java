package Programmers;

import java.util.*;

public class NoPeopleIsland_Prog {
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public int[] solution(String[] maps) {
		List<Integer> al = new ArrayList<>();
		List<int[]> mat = new ArrayList<>();
		visit = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			String str = maps[i];
			for (int j = 0; j < maps[i].length(); j++) {
				if (str.charAt(j) != 'X') {
					mat.add(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < mat.size(); i++) {
			int r = mat.get(i)[0];
			int c = mat.get(i)[1];
			if (!visit[r][c]) {
				al.add(bfs(r, c, maps));
			}
		}

		if (al.size() == 0) {
			int[] answer = new int[1];
			answer[0] = -1;
			return answer;
		}

		Collections.sort(al);
		// System.out.println(al.size());
		int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}

	static int bfs(int r, int c, String[] maps) {
		visit[r][c] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		int food = maps[r].charAt(c) - '0';

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dx[i];
				int nc = tmp[1] + dy[i];
				if (nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length() || visit[nr][nc]
						|| maps[nr].charAt(nc) == 'X') {
					continue;
				}
				food += maps[nr].charAt(nc) - '0';
				visit[nr][nc] = true;
				q.offer(new int[] { nr, nc });
			}
		}
		return food;
	}
}
