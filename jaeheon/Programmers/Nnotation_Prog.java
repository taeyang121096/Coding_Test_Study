package Programmers;

//10진수 : 0부터 시작
//열한번째 사람은 10안대 1, 0을 끊어서 말함
//그럼 열두번째는 1, 1
//이짓을 이진법부터 16진법까지
//n 은 몇진법이냐
//t는 구해야 할 숫자 길이
//m은 게임 참가 인원
//p는 순서

class Nnotaion_Prog {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		// t개에 총원 m명 -> t*m보다 작음
		for (int i = 0; i <= t * m; i++) {
			sb.append(Integer.toString(i, n).toUpperCase());
		}

		System.out.println(sb.toString());

		StringBuilder answer = new StringBuilder();
		// p번째만 t번 숫자 말함
		for (int i = p - 1; i < t * m; i += m) {
			answer.append(sb.charAt(i));
		}

		return answer.toString();
	}
}
