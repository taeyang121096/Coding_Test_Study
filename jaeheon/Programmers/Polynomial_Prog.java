package Programmers;

import java.util.*;

public class Polynomial_Prog {
	public String solution(String polynomial) {
		StringBuilder sb = new StringBuilder();

		String tmp = polynomial.replace(" + ", " ");
		String str[] = tmp.split(" ");

		int cnt = 0;
		int num = 0;
		for (String s : str) {
			if (s.length() >= 2) {
				if (s.substring(s.length() - 1, s.length()).equals("x")) {
					cnt += Integer.parseInt(s.substring(0, s.length() - 1));
				} else {
					num += Integer.parseInt(s);
				}
			} else {
				if (s.equals("x")) {
					cnt++;
				} else {
					num += Integer.parseInt(s);
				}
			}
		}

		if (cnt != 0) {
			if (cnt == 1) {
				sb.append("x");
			} else {
				sb.append(cnt).append("x");
			}

			if (num != 0) {
				sb.append(" + ").append(num);
			} else {
				sb.append("");
			}
		} else {
			sb.append("");
			if (num != 0) {
				sb.append(num);
			} else {
				sb.append("");
			}
		}

		return sb.toString();
	}
}
