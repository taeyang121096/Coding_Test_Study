package BOJ;

// 백준 1697 숨바꼭질
// 걷거나 순간이동 -> 1초
// 걸음 -> 1초이후에 x-1 or x+1
// 순간이동 2*x
// n, k : 10만

import java.util.*;
import java.io.*;

public class HideAndSeek_BOJ {

	static int n, k;
	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(arr[k]);
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		while (!q.isEmpty()) {
			n = q.poll();
			if (n == k) {
				break;
			}
			if (n - 1 >= 0 && arr[n - 1] == 0) {
				q.offer(n - 1);
				arr[n - 1] = arr[n] + 1;
			}
			if (n + 1 <= 100000 && arr[n + 1] == 0) {
				q.offer(n + 1);
				arr[n + 1] = arr[n] + 1;
			}
			if (n * 2 <= 100000 && arr[n * 2] == 0) {
				q.offer(n * 2);
				arr[n * 2] = arr[n] + 1;
			}
		}
	}
}
