package BOJ;

// 백준 15684 사다리 조작

// n - 세로선  m - 가로선 h - 세로선마다 놓을수 있는 위치의 개수
// 가로선 정보 (a, b) - b번 세로선과 b+1번 세로선을 a번에서 연결함 (1부터 시작)
// 가로선은 인접한 두 세로선만을 연결
// 오른쪽으로 갈 때마다 +1
// i가 i로 가도록 추가해야 하는 가로선 개수, 3보다 크면 -1 출력

import java.io.*;
import java.util.*;

public class Ladder_BOJ {

	static int n, m, h;
	static int answer;
	static boolean[][] ladder = new boolean[31][11]; // 30 x 10 크기
	static boolean check = false;
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 세로선 개수
		m = Integer.parseInt(st.nextToken()); // 가로선 개수
		h = Integer.parseInt(st.nextToken()); // 세로선마다 놓을 수 있는 위치의 개수

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}

		for (int i = 0; i <= 3; i++) {
			answer = i;
			dfs(1, 0);
			if (check) {
				System.out.println(answer);
				return;
			}
			if(answer >= 3) {
				System.out.println(-1);
			}
		}
	}

	private static void dfs(int level, int count) {

		if (count == answer) {
			possible = true;
			
			for (int i = 1; i <= n; i++) {
				int vertical = i;
				for (int j = 1; j <= h; j++) {
					if (ladder[j][vertical]) {
						vertical++;
					} else if (vertical > 1 && ladder[j][vertical - 1]) {
						vertical--;
					}
				}

				if (vertical != i) {
					possible = false;
					break;
				}
			}
			if (possible) {
				check = true;
			}
			
			return;
		}

		for (int i = level; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (!ladder[i][j - 1] && !ladder[i][j] && !ladder[i][j + 1]) {
					ladder[i][j] = true;
					dfs(i, count + 1);
					ladder[i][j] = false;
				}
			}
		}
		return;

	}
}
