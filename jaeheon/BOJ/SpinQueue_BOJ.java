package BOJ;

// 백준 1021 회전하는 큐
// n개의 원소를 포함하는 양방향 덱 -> n : 50개 이하
// 1. 첫번째 원소 poll
// 2. 왼쪽으로 한칸 이동 1 2 ... k -> 2 3 ...k 1
// 3. 오른쪽으로 한칸이동1 2 3 ... k -> k 1 2 3 ... k-1

import java.io.*;
import java.util.*;

public class SpinQueue_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 큐의 크기
		int m = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수

		int[] arr = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			deque.offer(i);
		}

		int answer = 0;

		for (int i = 0; i < m; i++) {
			int target = arr[i];
			int idx = 0;
			for (int k : deque) {
				if (k == target) {
					break;
				}
				idx++;
			}
			if (idx <= deque.size() / 2) {
				while (!deque.isEmpty() && target != deque.peek()) {
					deque.offerLast(deque.pollFirst());
					answer++;
				}
			} else {
				while (!deque.isEmpty() && target != deque.peek()) {
					deque.offerFirst(deque.pollLast());
					answer++;
				}
			}
			deque.poll();

		}
		System.out.println(answer);
	}
}
