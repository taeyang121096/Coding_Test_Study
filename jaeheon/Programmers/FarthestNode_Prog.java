package Programmers;

import java.util.*;

public class FarthestNode_Prog {
	public int solution(int n, int[][] edge) {
		int answer = 0;
		Queue<Integer> q = new ArrayDeque<>();

		boolean[][] map = new boolean[n + 1][n + 1];
		boolean[] check = new boolean[n + 1];

		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = true;
			map[edge[i][1]][edge[i][0]] = true;
		}

		q.offer(1);

		while (!q.isEmpty()) {
			answer = q.size();

			for (int i = 0; i < answer; i++) {
				int tmp = q.poll();

				for (int j = 2; j <= n; j++) {
					if (check[j] || !map[tmp][j]) {
						continue;
					}
					check[j] = true;
					q.add(j);

				}
			}
		}

		return answer;
	}

}
