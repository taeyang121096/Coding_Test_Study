package Programmers;

public class ContinuousNum_Prog {
	public int[] solution(int num, int total) {
		int[] answer = new int[num];

		if (num == 1) {
			answer[0] = total;
		}
		for (int i = -num; i <= total + num; i++) {
			int cnt = num - 1;
			int sum = i;
			for (int j = i + 1; j <= total + num; j++) {
				sum += j;
				cnt--;
				if (cnt == 0 && sum == total) {
					for (int k = 0; k < num; k++) {
						answer[k] = i + k;
					}
					break;
				}
			}
		}
		return answer;
	}
}
