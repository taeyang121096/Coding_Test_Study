package BOJ;

// 백준 1748 수 이어쓰기1
// 스트링빌더 쓰면 메모리초과
// 문자열의 길이가 아니라 개수로 생각해야함

import java.io.*;

public class WriteConsecutiveNum_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (i < 10) {
				answer += 1;
			}
			if (i >= 10 && i < 100) {
				answer += 2;
			}
			if (i >= 100 && i < 1000) {
				answer += 3;
			}
			if (i >= 1000 && i < 10000) {
				answer += 4;
			}
			if (i >= 10000 && i < 100000) {
				answer += 5;
			}
			if (i >= 100000 && i < 1000000) {
				answer += 6;
			}
			if (i >= 1000000 && i < 10000000) {
				answer += 7;
			}
			if (i >= 10000000 && i < 100000000) {
				answer += 8;
			}
			if (i == 100000000) {
				answer += 9;
			}

		}
		System.out.println(answer);
	}
}
