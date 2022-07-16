package Programmers;

public class HidePhoneNumber_Prog {
	public String solution(String phone_number) {
		String answer = "";

		int length = phone_number.length();

		String str = phone_number.substring(length - 4, length);
		String remain = phone_number.substring(0, length - 4);

		for (int i = 0; i < remain.length(); i++) {
			answer += "*";
		}
		answer += str;

		return answer;
	}
}
