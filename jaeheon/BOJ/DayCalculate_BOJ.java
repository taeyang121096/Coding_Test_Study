package BOJ;

// 백준 1476 java

import java.util.*;
import java.io.*;

public class DayCalculate_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(e == 15) {
			e = 0;
		}
		if(s == 28) {
			s = 0;
		}
		if(m == 19) {
			m = 0;
		}
		
		int year = 0;
		while (true) {
			year += 1;
			if (year % 15 == e && year % 28 == s && year % 19 == m) {
				break;
			}
		}
		System.out.println(year);
	}
}
