import java.util.*;
import java.io.*;

public class baek_9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String command;

		while (T-- > 0) {
			Stack<String> stack = new Stack<>();
			command = br.readLine();
			boolean res = true;

			for (int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);

				if(c=='(') {
					stack.push("(");
				}
				else {
					if (stack.empty()) {
						res = false;
					} else {
						stack.pop();
					}
				}
				if (!res)
					break;
			}
			if (res) {
				if (stack.empty()) {
					sb.append("YES").append('\n');
				} else {
					sb.append("NO").append('\n');
				}
			} else {
				sb.append("NO").append('\n');
			}
		}
		System.out.print(sb);

	}
}
