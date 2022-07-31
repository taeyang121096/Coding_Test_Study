package BOJ;

// 백준 10799 쇠막대기
// () -> 절단기
// 나머지는 막대기

import java.util.*;
import java.io.*;

public class IronStick_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		int answer = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			} else {
				stack.pop();
				if(str.charAt(i - 1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
