package BOJ;

import java.util.*;
import java.io.*;

public class IPTime_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] home = new int[n];
		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		int left = 0;
		int right = home[n - 1] - home[0];
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int now = home[0];
			for (int i = 1; i < n; i++) {
				if (home[i] - now >= mid) {
					cnt++;
					now = home[i];
				}
			}
			if (cnt < c) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
}
