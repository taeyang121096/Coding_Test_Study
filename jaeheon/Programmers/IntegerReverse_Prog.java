package Programmers;

import java.util.*;

public class IntegerReverse_Prog {
	public long solution(long n) {

		String str = String.valueOf(n);
		char[] tmp = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			tmp[i] = str.charAt(i);
		}

		Arrays.sort(tmp);

		StringBuilder sb = new StringBuilder();
		for (int i = tmp.length - 1; i >= 0; i--) {
			sb.append(tmp[i]);
		}
		long answer = Long.parseLong(sb.toString());
		return answer;
	}
}
