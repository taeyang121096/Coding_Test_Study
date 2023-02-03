package Programmers;

import java.util.*;

public class RoomRent_Prog {
	public int solution(String[][] book_time) {
		int answer = 0;

		int[][] arr = new int[book_time.length][2];
		int idx = 0;

		for (String[] str : book_time) {
			int start = hourToMin(str[0]);
			int end = hourToMin(str[1]) + 10;

			arr[idx][0] = start;
			arr[idx][1] = end;
			idx++;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		List<Integer> room = new ArrayList<>();

		for (int[] tmp : arr) {
			boolean flag = false;

			int start = tmp[0];
			int end = tmp[1];
			// room.add(end);

			Collections.sort(room);
			for (int i = 0; i < room.size(); i++) {
				int endTime = room.get(i);
				if (start >= endTime) {
					room.set(i, end);
					flag = true;
					break;
				}
			}
			if (!flag) {
				room.add(end);
			}
		}

		answer = room.size();

		return answer;
	}

	static int hourToMin(String time) {
		String[] tmp = time.split(":");
		return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
	}
}
