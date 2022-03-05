package BOJ;

// 백준 좋은구간 1059번

import java.util.*;
import java.io.*;

public class GoodSection_Prog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int right = Integer.MAX_VALUE;
		int left = 0;

		int num[] = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int k = Integer.parseInt(br.readLine());
		
		boolean find = false;
		
		for (int i = 0; i < n; i++) {
			if (num[i] > k) {
				right = Math.min(right, num[i]);
			} else if (num[i] < k) {
				left = Math.max(left, num[i]);
			} else {
				find = true;
				break;
			}
		}

		int L = k - left - 1;
		int R = right - k - 1;

		int answer = L + R + (L * R);

		if(find) {
			System.out.println(0); 
		}else {
			System.out.println(answer);
		}
	}
}
