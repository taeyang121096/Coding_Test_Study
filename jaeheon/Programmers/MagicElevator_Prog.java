package Programmers;

public class MagicElevator_Prog {
	class Solution {
		public int solution(int storey) {
			int answer = 0;

			String str = String.valueOf(storey);
			int[] arr = new int[str.length()];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = storey % 10;
				storey /= 10;
			}

			for (int i = 0; i < arr.length; i++) {
				if (i < arr.length - 1) {
					if (arr[i] > 5) {
						answer += 10 - arr[i];
						arr[i] = 0;
						arr[i + 1]++;
					} else if (arr[i] < 5) {
						answer += arr[i];
						arr[i] = 0;
					} else {
						if (arr[i + 1] >= 5) {
							answer += 10 - arr[i];
							arr[i] = 0;
							arr[i + 1]++;
						} else if (arr[i + 1] < 5) {
							answer += arr[i];
							arr[i] = 0;
						}
					}
				} else {
					if (arr[i] > 5) {
						answer += 10 - arr[i];
						answer++;
					} else {
						answer += arr[i];
					}
				}
			}

			return answer;
		}
	}
}
