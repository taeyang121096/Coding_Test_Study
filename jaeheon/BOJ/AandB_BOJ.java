package BOJ;

// 백준 12904 A와B

import java.io.*;

public class AandB_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		StringBuilder sb = new StringBuilder();
		// ABBA
		// ABB -> 뒤에 붙은 A를 제거
		// BA -> 뒤에 붙은 B를 제거 후 뒤집기
		// A -> 뒤에 붙은 A를 제거
		
		while(t.length() > s.length()) {
			if (t.endsWith("A")) {
				t = t.substring(0, t.length() - 1);
			} else if (t.endsWith("B")) {
				t = t.substring(0, t.length() - 1);
				t = sb.append(t).reverse().toString();
				sb.setLength(0);
			}
			
		}
		if(s.equals(t)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
