package Programmers;

//s는 알파벳, 숫자, 공백문자
//숫자는 단어의 첫 문자로만 나옴
//알파벳은 적어도 하나
//공백 연속 가능

class JadenCase_Prog {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();

		s = s.toLowerCase();
		String[] str = s.split(" ");

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("")) {
				sb.append(" ");
				continue;
			} else {
				str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
				if (i == str.length - 1) {
					sb.append(str[i]); // me
				} else {
					sb.append(str[i]).append(" "); // 3people, unfollowed
				}
			}
		}

		if (s.length() != sb.length()) {
			for (int i = 0; i <= s.length() - sb.length(); i++) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}
}