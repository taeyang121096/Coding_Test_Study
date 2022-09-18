package BOJ;

// 음이 아닌 정수
// 가장 큰 자릿수부터 작은 자릿수까지 감소
// 감소하는 수가 18번째면 42임

// 0 1 2 3 4 5 6 7 8 9
// 2^10 -1 -> 1024 - 1

// 3 30 31 32 310 320 321

import java.io.*;
import java.util.*;

public class DecreasingNum_BOJ {

	static List<Long> al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		al = new ArrayList<>();
		if (n <= 10) {
			System.out.println(n);
		} else if (n > 1022) {
			System.out.println(-1);
		} else {
			for (long i = 0; i < 10; i++) {
				dfs(i, 1);
			}
			Collections.sort(al);
			System.out.println(al.get(n));
		}
	}

	static void dfs(long num, int depth) {
		if (depth > 10) {
			return;
		}

		al.add(num);

		for (int i = 0; i < num % 10; i++) {
			dfs((num * 10) + i, depth + 1);
		}
		
	}
}
