package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class SW_1209 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= 10; T++) {
			int tc = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxSum[] = new int[4];
			int[] rowMax = new int[100];
			int[] colMax = new int[100];
			int left = 0;
			int right = 0;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					rowMax[i] += arr[i][j];
					colMax[i] += arr[j][i];

					if (i == j) {
						left += arr[i][j];
					}

					if (i + j == 99) {
						right += arr[j][i];
					}
				}
			}
			Arrays.sort(rowMax);
			Arrays.sort(colMax);
			maxSum[0] = rowMax[99];
			maxSum[1] = colMax[99];
			maxSum[2] = left;
			maxSum[3] = right;
			Arrays.sort(maxSum);
			sb.append("#").append(T).append(" ").append(maxSum[3]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
