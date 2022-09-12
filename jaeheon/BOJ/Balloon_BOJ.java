package BOJ;

import java.util.*;
import java.io.*;

public class Balloon_BOJ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> dq = new ArrayDeque<>();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sb.append("1 ");
		int now = arr[0];
		
		for(int i = 1; i < n; i++) {
			dq.offer(new int[] {(i+1), arr[i]}); // 풍선 인덱스, 풍선 번호
		}
		
		while(!dq.isEmpty()) {
			if(now > 0) {
				for(int i = 1; i < now; i++) {
					dq.offer(dq.poll());
				}
				int[] next = dq.poll();
				now = next[1];
				sb.append(next[0]).append(" ");
			} else {
				for(int i = 1; i < (-1)*now; i++) {
					dq.offerFirst(dq.pollLast());
				}
				int[] next = dq.pollLast();
				now = next[1];
				sb.append(next[0]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
