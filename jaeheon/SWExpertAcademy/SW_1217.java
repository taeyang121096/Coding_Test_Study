package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int answer = pow(num, p);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int pow(int num, int p) {
		if(p == 1) {
			return num;
		}
		return num * pow(num, p - 1);
	}
}
