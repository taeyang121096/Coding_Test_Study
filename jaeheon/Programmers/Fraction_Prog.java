package Programmers;

public class Fraction_Prog {
	public int[] solution(int denum1, int num1, int denum2, int num2) {
		int[] answer = new int[2];

		int num = num1 * num2;
		int denum = denum1 * num2 + denum2 * num1;

		answer[0] = denum;
		answer[1] = num;

		for (int i = num; i >= 2; i--) {
			if (num % i == 0 && denum % i == 0) {
				answer[0] = denum / i;
				answer[1] = num / i;
				break;
			}
		}

		return answer;
	}
}
