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
				// ( 가 입력되면 스택에 push 
				if(c=='(') {
					stack.push("(");
				}
				else {
					// )가 입력되었을때 스택이 비어있으면 false 스택이 차있으면 pop
					if (stack.empty()) {
						res = false;
					} else {
						stack.pop();
					}
				}
				if (!res)
					break;
			}
			//스택이 비어있으면 YES 그렇지 않거나 앞에서 false값이 전달됐으면 NO
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
