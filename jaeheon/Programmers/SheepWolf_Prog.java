package Programmers;

import java.util.*;

public class SheepWolf_Prog {
	static List<Integer>[] al;
	static boolean[][][] visit;
	static int answer = 1;

	public int solution(int[] info, int[][] edges) {

		al = new ArrayList[info.length];
		visit = new boolean[info.length][info.length + 1][info.length + 1];

		for (int i = 0; i < info.length; i++) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			int[] tmp = edges[i];
			al[tmp[0]].add(tmp[1]);
			al[tmp[1]].add(tmp[0]);
		}

		visit[0][0][0] = true;
		dfs(0, 0, 0, info); // 양, 늑대, 뎁스, info

		return answer;
	}

	static void dfs(int sheep, int wolf, int depth, int[] info) {
		int past = -1;
		if (info[depth] == 0) {
			past = 0;
			sheep++;
		} else if (info[depth] == 1) {
			past = 1;
			wolf++;
		}

		if (wolf >= sheep) {
			return;
		}
		answer = Math.max(answer, sheep);

		for (int i = 0; i < al[depth].size(); i++) {
			int next = al[depth].get(i);
			if (visit[next][sheep][wolf]) {
				continue;
			}
			info[depth] = -1;
			visit[depth][sheep][wolf] = true;
			dfs(sheep, wolf, next, info);
			info[depth] = past;
			visit[depth][sheep][wolf] = false;
		}
	}
}
