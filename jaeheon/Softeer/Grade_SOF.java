package Softeer;

import java.util.*;
import java.io.*;

public class Grade_SOF {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] score = new int[n];
		for (int i = 0; i < 3; i++) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] < o2[1]) {
						return 1;
					} else if (o1[1] > o2[1]) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(new int[] { j, num });
				score[j] += num;
			}

			int[] grade = find(pq, n);

			for (int j = 0; j < n; j++) {
				sb.append(grade[j]).append(" ");
			}
			sb.append("\n");
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1]) {
					return 1;
				} else if (o1[1] > o2[1]) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < n; i++) {
			pq.offer(new int[] { i, score[i] });
		}
		int[] scoreGrade = find(pq, n);
		for (int i = 0; i < n; i++) {
			sb.append(scoreGrade[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

	static int[] find(PriorityQueue<int[]> pq, int n) {
		int[] grade = new int[n];
		int[] first = pq.poll();
		int idx = 1;
		int cnt = 1;
		int last = first[1];
		grade[first[0]] = idx;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (last == tmp[1]) {
				cnt++;
			} else {
				idx += cnt;
				cnt = 1;
			}

			grade[tmp[0]] = idx;
			last = tmp[1];
		}
		return grade;
	}
}
