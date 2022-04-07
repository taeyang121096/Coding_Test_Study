package Programmers;

//던전의 개수 : 8개
//소모피로 내림차순 -> 30,10 못돌음
//소모피로 오름차순 -> 40 못돌음
//-> 완탐, dfs
//남은 피로도보다 필요 피로도가 높으면 방문할 수 없음
//남은 피로도가 필요피로도보다 많은 경우 방문
class Tired_Prog {

	static int answer = 0;
	static boolean[] visit;
	// static int cnt;

	static void dfs(int k, int[][] dungeons, int cnt, int idx) {

		if (idx == dungeons.length) {
			answer = Math.max(cnt, answer);
			return;
		}

		for (int i = 0; i < dungeons.length; i++) {
			if (dungeons[i][0] > k || visit[i]) {
				continue;
			} else {
				visit[i] = true;
				dfs(k - dungeons[i][1], dungeons, cnt + 1, idx + 1);
				visit[i] = false;
			}
		}
		dfs(k, dungeons, cnt, idx + 1);
	}

	public int solution(int k, int[][] dungeons) {

		visit = new boolean[dungeons.length];
		dfs(k, dungeons, 0, 0);

		return answer;
	}
}