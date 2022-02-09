package Programmers;

//n : 양의 정수  k : 진수
//1 ≤ n ≤ 1,000,000

class KPrime_Prog {

	public boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int solution(int n, int k) {
		int answer = 0;

		String s = "";
		while (n != 0) {
			s = n % k + s; // 만들어서 앞에 붙이기
			n = n / k; // k 진법
			// System.out.println(s);
		}

		String[] str = s.split("0");

		for (String input : str) {
			if (input.equals("")) {
				continue;
			}
			long number = Long.parseLong(input);
			if (isPrime(number)) {
				answer++;
			}
		}

		return answer;
	}
}
