package Programmers;

//수 k개를 제거하고 가장 큰 숫자 구하기
//number는 2자리 이상 백만 이하
//k는 1이상 number자리수 미만

class MakeBiggestNum_Prog {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		int idx = 0;

		for (int i = 0; i < number.length() - k; i++) {
			int max = Integer.MIN_VALUE;
			// char max = '0';
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j) - '0') { // max < number.charAt(j)
					max = number.charAt(j) - '0'; // max = number.charAt(j);
					idx = j + 1;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}