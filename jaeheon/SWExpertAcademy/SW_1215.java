package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1215 {
	static int cnt;
	static char[][] mat = new char[8][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			cnt = 0;
			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					mat[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					row(i, j, j + n - 1);
					col(i, j, j + n - 1);
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void row(int r, int start, int end) {
		if (start >= 0 && end <= 7 && mat[r][start] == mat[r][end]) {
			if (end <= start) {
				cnt++;
				return;
			}
			row(r, start + 1, end - 1);
		} else {
			return;
		}
	}

	static void col(int c, int start, int end) {
		if (start >= 0 && end <= 7 && mat[start][c] == mat[end][c]) {
			if (end <= start) {
				cnt++;
				return;
			}
			col(c, start + 1, end - 1);
		} else {
			return;
		}
	}
}
