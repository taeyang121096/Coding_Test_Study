package Programmers;

//가로 n, 세로 m : 2 ~ 30

import java.util.*;

public class Friends4Bolck_Prog {
	static boolean check(char[][] mat, int i, int j) {
		if (mat[i][j] == mat[i + 1][j] && mat[i + 1][j] == mat[i][j + 1] && mat[i][j + 1] == mat[i + 1][j + 1]
				&& mat[i + 1][j + 1] == mat[i][j]) {
			return true;
		} else {
			return false;
		}
	}

	public int solution(int m, int n, String[] board) {
		int answer = 0;

		char[][] mat = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = board[i].charAt(j);
			}
		}

		while (true) {
			boolean possible = false;
			boolean[][] visit = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (mat[i][j] == ' ') {
						continue;
					}

					if (check(mat, i, j)) {
						visit[i][j] = true;
						visit[i + 1][j] = true;
						visit[i][j + 1] = true;
						visit[i + 1][j + 1] = true;
						possible = true;
					}
				}
			}

			if (!possible) {
				break;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j]) {
						// System.out.println(mat[i][j]);
						mat[i][j] = ' ';
						answer++;
					}
				}
			}

			for (int a = 0; a < m; a++) {
				for (int i = 0; i < mat.length - 1; i++) {
					char c = 0;
					for (int j = 0; j < mat[0].length; j++) {
						if (mat[i][j] != ' ' && mat[i + 1][j] == ' ') {
							c = mat[i][j];
							mat[i + 1][j] = c;
							mat[i][j] = ' ';
						}
					}
				}
			}
		}
		return answer;
	}
}
