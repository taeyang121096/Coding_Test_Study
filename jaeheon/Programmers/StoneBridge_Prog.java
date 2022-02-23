package Programmers;

class StoneBridge_Prog {

	static int[] S;
	static int K;

	static boolean check(int val) {
		int empty = 0; // 못 건너는 징검다리 수

		for (int tmp : S) {
			if (tmp - val < 0) // 디딤돌 수 - 건너는 사람 수
				empty++; // 0보다 작으면 건널 수 없음
			else {
				empty = 0; // 0이상이면 건널 수 있음 -> 다른 지점으로 갈 수 있음
			}

			if (empty == K) // 못 건너는 징검다리가 k 넘으면 건널 수 없음
				return false;
		}

		return true;
	}

	public int solution(int[] stones, int k) {
		S = stones;
		K = k;
		int answer = 0;

		int min = 1; // 최소 수
		int max = 200000000; // 최대 수

		while (min <= max) {
			int mid = (min + max) / 2; // 건널 인원

			if (check(mid)) {
				min = mid + 1; // 건널 수 있으면 더 많은 사람이 건널 수 있는지 사람 수 늘림
				answer = Math.max(answer, mid);
			} else {
				max = mid - 1; // 건널 수 없으면 사람 수 줄임
			}
		}

		return answer;
	}
}
