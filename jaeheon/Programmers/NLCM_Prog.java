package Programmers;

//1 <= arr <= 15, 100이하 자연수
//최소공배수 : 두 수의 곱 / 두 수의 최대공약수

class NLCM_Prog {

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public int solution(int[] arr) {
		int answer = arr[0];

		for (int i = 1; i < arr.length; i++) {
			answer = answer * arr[i] / gcd(answer, arr[i]);
		}

		return answer;
	}
}