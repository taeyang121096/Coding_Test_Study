import java.util.*;
import java.io.*;

public class Parenthesis_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
	}
 
	public static String solve(String s) {
 
		Stack<Character> stack = new Stack<>();
 
		for (int i = 0; i < s.length(); i++) {
 
			char c = s.charAt(i);
 
			// 여는 괄호
			// 여는 괄호일 경우 스택에 넣음
			if (c == '(') {
				stack.push(c);
			}
			// 닫는 괄호
			// 스택이 비어있는 경우
			else if (stack.empty()) {
				return "NO";
			}
			// 스택에 하나 이상 존재
			else {
				stack.pop();
			}
		}
 
		 // 모든 검사 마치고 스택에 잔여 요소가 있으면 여는 괄호가 많은 경우는 "NO" 
		 // 스택이 비어있으면 온전한 수식이므로 "YES" 이다.
		if (stack.empty()) {
			return "YES";
		} 
		else {
			return "NO";
		}
	}
}
