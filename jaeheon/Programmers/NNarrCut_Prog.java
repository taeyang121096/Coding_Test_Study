package Programmers;

class NNarrCut_Prog {
	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left) + 1];

		int index = 0;
		for (long i = left; i <= right; i++) {
			answer[index++] = Math.max((int) (i / n) + 1, (int) (i % n) + 1);
		}

		return answer;
	}
}