package BOJ;

import java.io.*;

public class Shom_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 1; // 입력부분
		int num = 666; // 출력부분
		// 입력 출력
		// 1	666
		// 2	1666
		// 3	2666
		// 4	3666
		// 5	4666
		// 6	5666
		
		while(cnt != n) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}
