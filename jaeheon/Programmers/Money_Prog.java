package Programmers;

class Money_prog {
	public long solution(int price, int money, int count) {
		long answer = 0;

		long sum = 0;
		for (int i = 1; i <= count; i++) {
			sum += price * i;
		}

		if (money > sum) {
			return 0;
		} else {
			answer = sum - money;
		}

		return answer;
	}
}