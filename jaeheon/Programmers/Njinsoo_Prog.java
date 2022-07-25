package Programmers;

//진법 n
//t : 정답문자열 길이 1000 -> stringbuilder
//m : 게임참가 인원 -> t*m이 총 라운드
//p : 튜브의 순서
//튜브가 튜브의 순서에 말해야하는 숫자를 공백없이 나열

public class Njinsoo_Prog {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t * m; i++) {
			sb.append(Integer.toString(i, n).toUpperCase());
		}

		// 0 1 1 0 1 1 1 0 0 1 0 1 1 1 0 1 1 1
		// 2진법으로 변환된 수를
		// 2명의 인원이 진행하는데
		// 튜브의 순서는 첫번째
		// 정답 문자열 길이는 4
		// 0 1 1 1

		// System.out.print(sb.toString());

		StringBuilder ans = new StringBuilder();
		for (int i = p - 1; i < t * m; i++) {
			ans.append(sb.charAt(i));
			i = i + m - 1; // m명이니까
		}

		return ans.toString();
	}
}
