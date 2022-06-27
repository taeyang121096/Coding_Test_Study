package Programmers;

public class NumBlock_Prog {
	static int isPrime(int n) {
		if (n == 1) {
			return 0;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && n / i <= 10000000) {
				return n / i;
			}
		}
		return 1;
	}

	public int[] solution(long begin, long end) {
		int b = (int) begin;
		int e = (int) end;

		int[] answer = new int[e - b + 1];

		for (int i = b; i <= e; i++) {
			answer[i - b] = isPrime(i);
		}

		return answer;
	}
}
