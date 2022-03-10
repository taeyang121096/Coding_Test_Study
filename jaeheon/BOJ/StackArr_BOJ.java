package BOJ;

// 백준 1874 스택수열

import java.util.*;
import java.io.*;

public class StackArr_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> num = new Stack<>();

		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(br.readLine());
		}
		for (int i = n; i >= 1; i--) {
			num.push(i);
		}

		int now = 0;
		
		while (!num.isEmpty()) {
			stack.push(num.peek());
			sb.append("+").append("\n");
			num.pop();

			while (true) {
				if (!stack.isEmpty() && stack.peek() == seq[now]) {
					stack.pop();
					now++;
					sb.append("-").append("\n");
				} else
					break;
			}
		}
		if (stack.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}
}
