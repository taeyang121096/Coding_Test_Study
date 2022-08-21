package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1219 {
	static int answer;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			answer = 0;
			visit = new boolean[100];
			arr = new int[100][100];
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			dfs(0);

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int n) {
		if(n == 99) {
			answer = 1;
			return;
		}
		for(int i = 1; i < 100; i++) {
			if(arr[n][i] == 1 && !visit[i]) {
				visit[i] = true;
				dfs(i);
				visit[i] = false;
			}
		}
	}
}
