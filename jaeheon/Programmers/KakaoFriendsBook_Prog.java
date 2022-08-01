package Programmers;

import java.util.*;

public class KakaoFriendsBook_Prog {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visit;
	static int cnt;

	static void dfs(int x, int y, int[][] picture) {
		visit[x][y] = true;
		int nr;
		int nc;
		cnt++;
		for (int i = 0; i < 4; i++) {
			nr = x + dx[i];
			nc = y + dy[i];
			if (nr < 0 || nc < 0 || nr >= picture.length || nc >= picture[0].length) {
				continue;
			}
			if (picture[x][y] == picture[nr][nc] && !visit[nr][nc]) {
				dfs(nr, nc, picture);
			}
		}
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visit = new boolean[m][n];
		cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visit[i][j]) {
					numberOfArea++;
					dfs(i, j, picture);
				}
				maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
				cnt = 0;
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}
