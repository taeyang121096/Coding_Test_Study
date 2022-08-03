package Programmers;

//전력망을 끊어서 2개로 분할
//송전탑의 개수 n : 2 ~ 100
//송전탑 개수가 가능한 비슷하도록 -> math.min(math.abs)
//wires [v1, v2] -> v1번 송전탑과 v2번 송전탑이 연결되어 있음
import java.util.*;

public class DivideElectro_Prog {
	static int[][] mat;

	public int solution(int n, int[][] wires) {
		int answer = 100;
		mat = new int[n + 1][n + 1];
		for (int i = 0; i < wires.length; i++) {
			mat[wires[i][0]][wires[i][1]] = 1;
			mat[wires[i][1]][wires[i][0]] = 1;
		}

		int cnt = 0;
		for (int i = 0; i < wires.length; i++) {
			int target1 = wires[i][0];
			int target2 = wires[i][1];

			mat[target1][target2] = 0;
			mat[target2][target1] = 0;

			// cnt, n - cnt
			cnt = bfs(target1, n);

			answer = Math.min(answer, Math.abs(n - (2 * cnt)));

			mat[target1][target2] = 1;
			mat[target2][target1] = 1;
		}
		return answer;
	}

	static int bfs(int t, int n) {
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 1;
		q.offer(t);

		while (!q.isEmpty()) {
			int now = q.poll();
			visit[now] = true;
			for (int i = 1; i <= n; i++) {
				if (visit[i]) {
					continue;
				}
				if (mat[now][i] == 1 && !visit[i]) {
					q.offer(i);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
