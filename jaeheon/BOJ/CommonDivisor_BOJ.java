package BOJ;

// 백준 2436 공약수

// 앞의 값을 최대 공약수로
// 뒤의 값을 최대 공배수로

// 각각 10억

import java.util.*;
import java.io.*;

public class CommonDivisor_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());

		long mul = (long) gcd * lcm;

		int a = 0;
		int b = 0;
		int answer1 = 0;
		int answer2 = 0;
		int tmp = Integer.MAX_VALUE;
		for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
			if (mul % i == 0) {
				long res = cal(i, mul / i);
				if (res == gcd) {
					a = i;
					b = (int)(mul / i);
					if(tmp > a + b) {
						tmp = a + b;
						answer1 = a;
						answer2 = b;
					}
				}
			}
		}
		System.out.println(answer1 + " " + answer2);
	}

	static long cal(long a, long b) {
		long tmp;
		long n;
		if (a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}

		return a;
	}
}
