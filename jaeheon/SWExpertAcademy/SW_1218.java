package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int answer;
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < n; i++) {
				char ch = str.charAt(i);
				if(ch == ')' && stack.peek() == '(') {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						answer = 0;
						break;
					}
				} else if (ch == '}' && stack.peek() == '{') {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						answer = 0;
						break;
					}
				} else if(ch == ']' && stack.peek() == '[') {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						answer = 0;
						break;
					}
				} else if(ch == '>' && stack.peek() == '<') {
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						answer = 0;
						break;
					}
				} else {
					stack.push(ch);
				}
			}
			
			if(stack.isEmpty()) {
				answer = 1;
			} else {
				answer = 0;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
