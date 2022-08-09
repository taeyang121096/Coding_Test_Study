package BOJ;

// 백준 2231 분해합

import java.io.*;

public class DecompositionSum_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String num = String.valueOf(i);
			int sum = 0;

			for (int j = 0; j < num.length(); j++) {
				sum += Character.getNumericValue(num.charAt(j));
//				sum += num.charAt(j) - '0';
			}
			sum += Integer.parseInt(num);

			if (sum == n) {
				System.out.println(num);
				break;
			} else if (n == i) {
				System.out.println(0);
			}
		}
	}
}
