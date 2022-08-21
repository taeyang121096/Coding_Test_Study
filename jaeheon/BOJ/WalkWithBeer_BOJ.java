package BOJ;

import java.util.*;
import java.io.*;

public class WalkWithBeer_BOJ {
	static int n;
	static int startX, startY;
	static int finishX, finishY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			List<int[]> al = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (i == 0) {
					startX = a;
					startY = b;
				} else if (i == n + 1) {
					finishX = a;
					finishY = b;
				} else {
					al.add(new int[] { a, b });
				}
			}
			if (bfs(al)) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static boolean bfs(List<int[]> al) {
		boolean[] visit = new boolean[n];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { startX, startY });
		while (!q.isEmpty()) {
			int[] store = q.poll();
			int storeX = store[0];
			int storeY = store[1];
			if (Math.abs(store[0] - finishX) + Math.abs(store[1] - finishY) <= 1000) {
				return true;
			}
			for (int i = 0; i < n; i++) {
				if (!visit[i]) {
					int nr = al.get(i)[0], nc = al.get(i)[1];
					int distance = Math.abs(storeX - nr) + Math.abs(storeY - nc);
					if (distance <= 1000) {
						visit[i] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
		return false;
	}
}
