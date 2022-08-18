package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1216 {
	static char[][] mat = new char[100][100];
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			answer = 0;
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					mat[i][j] = str.charAt(j);
				}
			}

			int max = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 99; j++) {
					int left = j - 1;
					int right = j + 1;
					int cnt = 1;
					if (mat[i][left] == mat[i][right]) {
						while (left > 0 && right < 99) {
							if (mat[i][left] == mat[i][right]) {
								left--;
								right++;
								cnt += 2;
								if (cnt > max) {
									max = cnt;
								}
							} else {
								cnt = 1;
								break;
							}
						}
					} else if (mat[i][j] == mat[i][right]) {
						cnt++;
						while (left > 0 && right < 99) {
							if (mat[i][left] == mat[i][right + 1]) {
								left--;
								right++;
								cnt += 2;
								if (cnt > max) {
									max = cnt;
								}
							} else {
								cnt = 1;
								break;
							}
						}
					}
				}
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 99; j++) {
					int top = j - 1;
					int bottom = j + 1;
					int cnt = 1;
					if (mat[top][i] == mat[bottom][i]) {
						while (top > 0 && bottom < 99) {
							if (mat[top][i] == mat[bottom][i]) {
								top--;
								bottom++;
								cnt += 2;
								if (cnt > max) {
									max = cnt;
								}
							} else {
								cnt = 1;
								break;
							}
						}
					} else if (mat[j][i] == mat[bottom][i]) {
						cnt++;
						while (top > 0 && bottom < 99) {
							if (mat[top][i] == mat[bottom + 1][i]) {
								top--;
								bottom++;
								cnt += 2;
								if (cnt > max) {
									max = cnt;
								}
							} else {
								cnt = 1;
								break;
							}
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
