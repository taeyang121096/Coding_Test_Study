package Programmers;

class YinYang_Prog {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else if (!signs[i]) {
				answer -= absolutes[i];
			}
		}

		return answer;
	}
}