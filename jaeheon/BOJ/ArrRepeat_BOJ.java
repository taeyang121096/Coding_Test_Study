package BOJ;

// 백준 문자열 반복 2675
// 문자열 반복을 하는데 주어진 숫자만큼 각각을 출력
// 테스트케이스 1 ~ 1000
// 반복횟수 1 ~ 8

import java.util.*;
import java.io.*;

public class ArrRepeat_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int j = 0; j < str.length(); j++) {
				for(int k = 0; k < r; k++) {
					sb.append(str.charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
	}
}
