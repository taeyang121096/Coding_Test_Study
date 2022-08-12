package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1204 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] student = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				student[score]++;
			}
			int max = student[0];
			int answer = 0;
			for (int i = 1; i < 101; i++) {
				if (max <= student[i]) {
					max = student[i];
					answer = i;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}