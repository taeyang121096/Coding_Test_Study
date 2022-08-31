package Programmers;

public class LongestPalindrome_Prog {
	public int solution(String s) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			int left = i;
			int right = len - 1;
			int now = 0;
			int idx = 1;
			while (left < right) {
				if (s.charAt(left) == s.charAt(right)) {
					left++;
					right--;
					now += 2;
				} else {
					now = 0;
					left = i;
					right = len - 1 - idx;
					idx++;
				}
			}
			if (left == right) {
				now++;
			}
			if (max > now) {
				answer = max;
			} else {
				max = now;
			}
		}
		answer = max;

		return answer;
	}
}
