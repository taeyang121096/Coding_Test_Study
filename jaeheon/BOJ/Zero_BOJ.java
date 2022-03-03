package BOJ;

//백준 10773 제로

import java.util.*;
import java.io.*;

public class Zero_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}

		if (stack.size() == 0) {
			System.out.println(0);
		} else {
			for (int j = 0; j < stack.size(); j++) {
				sum += stack.get(j);
			}
			System.out.println(sum);
		}
	}
}
