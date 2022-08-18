import java.io.*;
import java.util.*;

public class Day4_Parentheses {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int T = 1; T <= 10; T++) {
			int size = Integer.parseInt(br.readLine());
			String N = br.readLine();
			Stack<Character> stack = new Stack<>();
			int answer = 1;

			for (int i = 0; i < size; i++) {
				char ch = N.charAt(i);

				switch (ch) {
				case '(':
				case '{':
				case '[':
				case '<':
					stack.push(ch);
					break;
				case ')':
					if (!stack.isEmpty()) {
						if (stack.peek() == '(') {
							stack.pop();
							break;
						}
					}
					answer = 0;
					break;
				case '}':
					if (!stack.isEmpty()) {
						if (stack.peek() == '{') {
							stack.pop();
							break;
						}
					}
					answer = 0;
					break;
				case ']':
					if (!stack.isEmpty()) {
						if (stack.peek() == '[') {
							stack.pop();
							break;
						}
					}
					answer = 0;
					break;
				case '>':
					if (!stack.isEmpty()) {
						if (stack.peek() == '<') {
							stack.pop();
							break;
						}
					}
					answer = 0;
					break;
				}
				if(answer == 0) break;
			}
			if (!stack.isEmpty()) {
				answer = 0;
			}
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
