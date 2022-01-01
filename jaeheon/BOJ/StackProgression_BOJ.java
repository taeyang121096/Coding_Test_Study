import java.io.*;
import java.util.*;

public class StackProgression_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int index = 1;
		
		for(int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			while(index <= val) {
				stack.push(index++);
				sb.append("+\n");
			}
			if(val == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());
		
	}
}
