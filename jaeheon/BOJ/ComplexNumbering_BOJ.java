package BOJ;

// 백준 2667 단지번호 붙이기

// dfs

// 5≤N≤25
// 첫번째 줄에는 단지 수 출력
// 그 다음부터는 단지 내 집의 수를 오름차순

import java.io.*;
import java.util.*;

public class ComplexNumbering_BOJ {
	static int n;
	static int[] complex;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		complex = new int[n*n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);

		Arrays.sort(complex);
		
		for (int i = 0; i < complex.length; i++) {
			if(complex[i] > 0) {
				System.out.println(complex[i]);
			}
		}
	}

	static void dfs(int r, int c) {

		visit[r][c] = true;
		complex[cnt]++;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if (arr[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}

	}
}
