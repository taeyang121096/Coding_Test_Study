package BOJ;

// 백준 9012 괄호

import java.util.*;
import java.io.*;

public class PS_BOJ {

	static boolean check(String str) {
		Stack<Character> stack = new Stack<>();

		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(0) == ')') {
				return false;
			}

			if (str.charAt(j) == '(') {
				stack.push(str.charAt(j));
			} else if (str.charAt(j) == ')') {
				if (stack.size() > 0) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = String.valueOf(br.readLine());
			
			if(check(str)) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

}
