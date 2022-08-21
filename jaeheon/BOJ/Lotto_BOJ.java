package BOJ;

// 백준 6603 로또

import java.util.*;
import java.io.*;

public class Lotto_BOJ {

	static int n;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}
			String[] num = str.split(" ");
			n = Integer.parseInt(num[0]);
			arr = new int[n];
			visit = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(num[i + 1]);
			}
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int depth, int at) {
		if (depth == 6) {
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
		}
		for (int i = at; i < n; i++) {
			visit[i] = true;
			dfs(depth + 1, i + 1);
			visit[i] = false;
		}
	}
}
