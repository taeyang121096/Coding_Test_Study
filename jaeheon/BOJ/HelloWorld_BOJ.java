package BOJ;

import java.util.*;
import java.io.*;

public class HelloWorld_BOJ {

	static boolean[] visit;
	static int[] arr;
	static int n;
	static int[] hello = { 1, 2, 3, 3, 4 };
	static int[] world = { 5, 4, 6, 3, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visit = new boolean[10];
		arr = new int[7];
		dfs(0);
		if (sb.length() == 0) {
			System.out.println("No Answer");
		}
	}

	static void dfs(int depth) {
		if (depth == 7) {
			if (arr[hello[0]] == 0 || arr[world[0]] == 0) {
				return;
			}

			int sum = 0;

			sum += arr[hello[0]] * 10000;
			sum += arr[hello[1]] * 1000;
			sum += arr[hello[2]] * 100;
			sum += arr[hello[3]] * 10;
			sum += arr[hello[4]] * 1;

			sum += arr[world[0]] * 10000;
			sum += arr[world[1]] * 1000;
			sum += arr[world[2]] * 100;
			sum += arr[world[3]] * 10;
			sum += arr[world[4]] * 1;

			if (sum == n) {
				sb.append("  ");

				for (int i = 0; i < 5; i++) {
					sb.append(arr[hello[i]]);
				}
				sb.append("\n");
				sb.append("+ ");
				for (int i = 0; i < 5; i++) {
					sb.append(arr[world[i]]);
				}
				sb.append("\n");
				sb.append("-------");
				sb.append("\n");
				
				if(sum >= 100000) {
					sb.append(" ");
					sb.append(sum);
				} else if(sum < 100000) {
					sb.append("  ");
					sb.append(sum);
				}
				
//				sb.append("\n");
				System.out.println(sb.toString());
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
