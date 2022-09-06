package Programmers;

public class Wifi_Prog {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int position = 1;
		int idx = 0;

		while (position <= n) {
			if (idx >= stations.length || position < stations[idx] - w) {
				answer++;
				position += w + 1 + w;
			} else {
				position = stations[idx] + w + 1;
				idx++;
			}
		}

		return answer;
	}
}
