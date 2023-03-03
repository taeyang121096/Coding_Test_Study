package Programmers;

public class PerseSubSequence_Prog {
	static int n;

	public long solution(int[] sequence) {
		long answer = 0;

		n = sequence.length;

		int[] pArr = new int[n];
		int[] nArr = new int[n];

		int a = 1;
		int b = -1;

		for (int i = 0; i < n; i++) {
			if (i > 0) {
				a *= -1;
				b *= -1;
			}
			pArr[i] = sequence[i] * a;
			nArr[i] = sequence[i] * b;
		}

		long maxP = findMax(pArr);
		long maxN = findMax(nArr);

		answer = Math.max(maxP, maxN);

		return answer;
	}

	static long findMax(int[] arr) {
		long max = Integer.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = Math.max(sum, 0) + arr[i];
			max = Math.max(sum, max);
		}

		return max;
	}
}
