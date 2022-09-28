package BOJ;

import java.util.*;
import java.io.*;

public class SumIsZero {

	static int[] arr;
	static int[] res;
	static int n;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		res = new int[3];
		dfs(0, 0);
		System.out.println(cnt);
	}

	static void dfs(int depth, int at) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				sum += res[i];
			}
			if (sum == 0) {
				cnt++;
			}
			return;
		}
		for (int i = at; i < n; i++) {

			res[depth] = arr[i];
			dfs(depth + 1, i + 1);

		}
	}
}
