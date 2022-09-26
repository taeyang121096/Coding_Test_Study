package BOJ;

import java.util.*;
import java.io.*;

public class SquareOfNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int answer = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int a = n * (-1); a < n; a++) {
					for (int b = m * (-1); b < m; b++) {
						
						if(a == 0 && b == 0) {
							continue;
						}
						
						int row = i;
						int col = j;
						int num = 0;

						while (row >= 0 && col >= 0 && row < n && col < m) {

							num = (num * 10) + arr[row][col];

							if (check(num)) {
								answer = (int) Math.max(answer, num);
							}
							
							row += a;
							col += b;
						}

					}
				}
			}
		}
		System.out.println(answer);
	}

	static boolean check(int num) {
		int tmp = (int) Math.sqrt(num);
		if (tmp * tmp == num) {
			return true;
		} else {
			return false;
		}
	}
}
