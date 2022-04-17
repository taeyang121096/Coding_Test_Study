package Programmers;

//좌표 평면 -5 ~ 5
//u, d, r, l
//끝점에서 더 이상 갈 수 없으면 그 이후 명령어는 무시
//처음 걸어본 길이 : 두번 이상 지나간 경로는 하나로 취급
//무조건 (0,0)에서 시작


class VisitLength_Prog {
	public int solution(String dirs) {
		int answer = 0;

		String[] op = new String[dirs.length()];
		boolean[][][][] visit = new boolean[11][11][11][11];

		for (int i = 0; i < dirs.length(); i++) {
			op[i] = dirs.substring(i, i + 1);
		}

		int x = 0;
		int y = 0;

		for (int i = 0; i < op.length; i++) {

			int nx = x;
			int ny = y;

			if (op[i].equals("U")) {
				ny++;
			} else if (op[i].equals("D")) {
				ny--;
			} else if (op[i].equals("R")) {
				nx++;
			} else if (op[i].equals("L")) {
				nx--;
			}

			if (nx > 5 || nx < -5 || ny > 5 || ny < -5) {
				continue;
			}

			if (visit[x + 5][y + 5][nx + 5][ny + 5] == false && visit[nx + 5][ny + 5][x + 5][y + 5] == false) {
				visit[x + 5][y + 5][nx + 5][ny + 5] = true;
				visit[nx + 5][ny + 5][x + 5][y + 5] = true;
				answer++;
			}

			x = nx;
			y = ny;
			// System.out.println(nx + " " + ny);
		}
		// System.out.println();
		// System.out.println(x + " " + y);

		return answer;
	}
}