import java.io.*;
import java.util.*;

// 백준 바이러스   2606
public class Virus_BOJ {

	static boolean[] check;
	static int[][] arr;
	static int n;
	static int line;
	static int count = 0;
	static StringTokenizer st;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());

		check = new boolean[n + 1];
		arr = new int[n + 1][n + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());

			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			arr[left][right] = arr[right][left] = 1;
		}

		dfs(1);

		sb.append(count - 1);
		System.out.println(sb);
	}

	public static void dfs(int start) {
		check[start] = true;
		count++;

		for (int i = 0; i <= n; i++) {
			if (arr[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}
}
