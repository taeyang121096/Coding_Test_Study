package BOJ;

import java.util.*;
import java.io.*;

public class LightningBug_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] up = new int[n / 2];
		int[] down = new int[n / 2];

		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				down[idx1] = tmp;
				idx1++;
			} else {
				up[idx2] = tmp;
				idx2++;
			}
		}

		Arrays.sort(up); // 1 2 3 4 5 6
		Arrays.sort(down); // ~~~~

		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= h; i++) {
			int obs1 = binarySearch(i, 0, n / 2, down);
			int obs2 = binarySearch(h - i + 1, 0, n / 2, up);
			if (min == obs1 + obs2) {
				cnt++;
			} else if(min > obs1 + obs2) {
				min = obs1 + obs2;
				cnt = 1;
			}
		}
		System.out.println(min + " " + cnt);
	}

	static int binarySearch(int height, int left, int right, int[] arr) {
		while(left < right) {
			int mid = (left + right) / 2;
			if(arr[mid] >= height) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return arr.length - right;
	}
}
