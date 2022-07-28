package BOJ;

// 백준 1966 프린터 큐

// 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치
// 아니면 인쇄

import java.io.*;
import java.util.*;

public class PrinterQueue_BOJ {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		for (int i = 0; i < testCase; i++) {
//			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
//			int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서가 현재 queue의 몇번째에 놓여있는지
//
//			int[] arr = new int[n];
//			
//			// "1" 1 9 1 1 1
//
//			// 1 9 1 1 1 "1"
//			// 9 1 1 1 "1" 1 -> 1번째로 9인쇄
//			// 1 1 1 "1" 1 -> 2번째로 1인쇄
//			// 1 1 "1" 1 -> 3번째로 1인쇄
//			// 1 "1" 1 -> 4번째로 1인쇄
//			// "1" 1 -> 5번째로 "1"인쇄
//
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < n; j++) {
//				int num = Integer.parseInt(st.nextToken());
//				pq.offer(num); // 9 1 1 1 1 1
//				arr[j] = num;  // 1 1 9 1 1 1
//			}
//
//			int answer = 0;
//			int idx = 0;
//			
//			while (pq.size() > 0) {
//				int target = pq.poll();
//				while (arr[idx] != target) {
//					idx++;
//					if (idx == n) {
//						idx = 0;
//					}
//				}
//				if (arr[idx] == target) {
//					answer++;
//					if (idx == m) {
//						break;
//					}
//					idx++;
//					if (idx == n) {
//						idx = 0;
//					}
//				}
//			}
//			System.out.println(answer);
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			Deque<Integer> dq = new ArrayDeque<>();
			Deque<Integer> idxq = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
			int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서가 현재 queue의 몇번째에 놓여있는지

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
		
			for(int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				dq.offer(tmp);
				arr[i] = tmp;
				idxq.offer(j);
			}
			
			int cnt = 1;
			
			// "1" 1 9 1 1 1
//			// 1 9 1 1 1 "1"
//			// 9 1 1 1 "1" 1 -> 1번째로 9인쇄
//			// 1 1 1 "1" 1 -> 2번째로 1인쇄
//			// 1 1 "1" 1 -> 3번째로 1인쇄
//			// 1 "1" 1 -> 4번째로 1인쇄
//			// "1" 1 -> 5번째로 "1"인쇄
			
			while(!dq.isEmpty()) {
				int now = Collections.max(dq);
				int target = dq.poll();
				int targetIdx = idxq.poll();
				if(now == target) {
					if(targetIdx == m) {
						System.out.println(cnt);
						break;
					}
					cnt++;
				} else {
					dq.offer(target);
					idxq.offer(targetIdx);
				}
			}
		}
	}
}
