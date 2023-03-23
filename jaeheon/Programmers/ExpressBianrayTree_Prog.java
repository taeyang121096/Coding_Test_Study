package Programmers;

public class ExpressBianrayTree_Prog {
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String str = Long.toString(numbers[i], 2);
			str = make(str);
			// System.out.println(str);
			if (check(str)) {
				answer[i] = 1;
			}
		}

		return answer;
	}

	static boolean check(String str) {

		if (str.length() == 1) {
			return true;
		}

		int mid = str.length() / 2;
		int root = str.charAt(mid) - '0';
		// System.out.println(root);

		String left = str.substring(0, mid);
		String right = str.substring(mid + 1);

		int lRoot = left.charAt(left.length() / 2) - '0';
		int rRoot = right.charAt(right.length() / 2) - '0';
		// System.out.println(lRoot + " " + rRoot);

		if (check(left) && check(right)) {
			if (root == 1) {
				return true;
			}
			if (lRoot == 0 && rRoot == 0) {
				return true;
			}
		}

		return false;
	}

	static String make(String str) {
		StringBuilder sb = new StringBuilder();

		int n = 1;
		while (true) {
			if (str.length() <= Math.pow(2, n) - 1) {
				break;
			}
			n++;
		}

		int plus = (int) (Math.pow(2, n) - 1) - str.length();

		for (int i = 0; i < plus; i++) {
			sb.append(0);
		}
		sb.append(str);
		return sb.toString();
	}
}
