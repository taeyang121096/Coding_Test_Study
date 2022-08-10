package BOJ;

// 백준 2110 공유기 설치
// 가장 인접한 두 공유기 사이의 최대거리
// 1 2 4 8 9
// '설치 해야 할 공유기의 개수(M)'와 같은 거리 중 최대로 가질 수 있는 '최소 거리'를 찾는 것

import java.util.*;
import java.io.*;

public class Router_BOJ {
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
