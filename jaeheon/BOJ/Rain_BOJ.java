package BOJ;

import java.io.*;
import java.util.*;

public class Rain_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] block = new int[w];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < w; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

//		int answer = 0;

//		for (int i = 1; i < w - 1; i++) {
//			int left = 0;
//			int right = 0;
//
//			for (int j = 0; j < i; j++) {
//				left = Math.max(block[j], left);
//			}
//
//			for (int j = i + 1; j < w; j++) {
//				right = Math.max(block[j], right);
//			}
//
//			if (block[i] < left && block[i] < right) {
//				answer += Math.min(left, right) - block[i];
//			}
//		}
//		System.out.println(answer);

		int left = 0; // 0
		int right = block.length - 1; // 7 6 5 4
		int maxl = -1;
		int maxr = -1;

		int answer = 0;

		while (left < right || left > right) {
			maxl = Math.max(maxl, block[left]);  // 3
			maxr = Math.max(maxr, block[right]); // 2 2 4

			if (maxl <= maxr) {
				left++;
				if (maxl <= block[left]) {
					continue;
				} else {
					answer += maxl - block[left];
				}
			} else if(maxl > maxr){
				right--;
				if (maxr <= block[right]) { // break
					continue;
				} else {
					answer += maxr - block[right]; // 1 1
				}
			}
		}
		
		System.out.println(answer);
	}
}
