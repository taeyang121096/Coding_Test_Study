package Programmers;

//행을 모두 뒤집거나 열을 모두 뒤집음
//10 * 10 이하
//0 앞면 1 뒷면

public class CoinFlip_Prog {
	static int n, m;
	static int answer;
	static int[][] begin;
	static int[][] goal;

	public int solution(int[][] beginning, int[][] target) {
		answer = 11;

		n = beginning.length;
		m = beginning[0].length;

		begin = new int[n][m];
		goal = new int[n][m];
		for (int i = 0; i < beginning.length; i++) {
			for (int j = 0; j < beginning[i].length; j++) {
				begin[i][j] = beginning[i][j];
			}
		}
		for (int i = 0; i < beginning.length; i++) {
			for (int j = 0; j < beginning[i].length; j++) {
				goal[i][j] = target[i][j];
			}
		}

		dfs(0, 0, 0);

		if (answer == 11) {
			return -1;
		}

		return answer;
	}

	static void dfs(int r, int c, int cnt) {
		if (r < n) { // 뒤집기
			dfs(r + 1, c, cnt); // 행 안뒤집기
			flipR(r);
			dfs(r + 1, c, cnt + 1); // 행 뒤집기
			flipR(r);
		} else { // 모든 행에서 작업 끝
			boolean flag = false;
			for (int i = 0; i < m; i++) {
				int tmp = check(i);
				if (tmp == -1) {
					flag = true;
					continue;
				}
				cnt += tmp;
			}
			if (!flag) {
				answer = Math.min(answer, cnt);
				return;
			}
		}
	}

	static int check(int c) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (begin[i][c] == goal[i][c]) {
				cnt++;
			}
		}
		if (cnt == 0) {
			return 1;
		} else if (cnt == n) {
			return 0;
		} else {
			return -1;
		}
	}

	static void flipR(int r) {
		for (int i = 0; i < m; i++) {
			if (begin[r][i] == 1) {
				begin[r][i] = 0;
			} else {
				begin[r][i] = 1;
			}
		}
	}

}
