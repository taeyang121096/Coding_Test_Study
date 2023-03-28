package Programmers;

public class Park_Prog {
	static char[][] arr;
	static int n, m;
	static int startX, startY;

	public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		n = park.length;
		m = park[0].length();
		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = park[i];
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				arr[i][j] = ch;
				if (ch == 'S') {
					startX = i;
					startY = j;
				}
			}
		}

		int nowX = 0;
		int nowY = 0;

		for (int i = 0; i < routes.length; i++) {
			String[] tmp = routes[i].split(" ");
			String command = tmp[0];
			int move = Integer.parseInt(tmp[1]);
			nowX = startX;
			nowY = startY;
			if (command.equals("N")) {
				nowX -= move;
				if (nowX < 0) {
					nowX += move;
					continue;
				}
				for (int j = 0; j <= move; j++) {
					if (arr[nowX + j][nowY] == 'X') {
						nowX += move;
						break;
					}
				}
				startX = nowX;
			}
			if (command.equals("S")) {
				nowX += move;
				if (nowX >= n) {
					nowX -= move;
					continue;
				}
				for (int j = 0; j <= move; j++) {
					if (arr[nowX - j][nowY] == 'X') {
						nowX -= move;
						break;
					}
				}
				startX = nowX;
			}
			if (command.equals("W")) {
				nowY -= move;
				if (nowY < 0) {
					nowY += move;
					continue;
				}
				for (int j = 0; j <= move; j++) {
					if (arr[nowX][nowY + j] == 'X') {
						nowY += move;
						break;
					}
				}
				startY = nowY;
			}
			if (command.equals("E")) {
				nowY += move;
				if (nowY >= m) {
					nowY -= move;
					continue;
				}

				for (int j = 0; j <= move; j++) {
					if (arr[nowX][nowY - j] == 'X') {
						nowY -= move;
						break;
					}
				}
				startY = nowY;
			}
		}

		answer[0] = startX;
		answer[1] = startY;

		return answer;
	}
}
