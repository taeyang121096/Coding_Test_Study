package Programmers;

public class TikTacToe_Prog {
	static char[][] map;
	static int oCnt;
	static int xCnt;

	public int solution(String[] board) {

		map = new char[3][3];
		for (int i = 0; i < 3; i++) {
			String str = board[i];
			for (int j = 0; j < 3; j++) {
				char ch = str.charAt(j);
				if (ch == 'O') {
					oCnt++;
				}
				if (ch == 'X') {
					xCnt++;
				}
				map[i][j] = ch;
			}
		}
		if (xCnt > oCnt) {
			return 0;
		}

		if (find()) {
			return 1;
		} else {
			return 0;
		}
	}

	static boolean find() {
		if (oCnt + xCnt == 0) {
			return true;
		}

		if (oCnt + xCnt == 9) { // 이미 다 참
			if (oCnt - xCnt != 1 || check('X')) {
				return false;
			}
			return true;
		} else { // 아직 안참
			if (oCnt == xCnt) { // x로 끝나야 함
				if (!check('O') && !check('X')) {
					return true;
				} else if (!check('O') && check('X')) {
					// System.out.println(!check('O') + " " + check('X'));
					return true;
				} else {
					// System.out.println(!check('O') + " " + check('X'));
					return false;
				}
			} else if (oCnt - xCnt == 1) { // o로 끝나야함
				if (!check('O') && !check('X')) {
					return true;
				} else if (check('O') && !check('X')) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	static boolean check(char ch) {

		for (int i = 0; i < 3; i++) {
			if (map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch) {
				return true;
			}
		}

		if (map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) {
			return true;
		}

		if (map[0][2] == ch && map[1][1] == ch && map[2][0] == ch) {
			return true;
		}

		return false;
	}
}
